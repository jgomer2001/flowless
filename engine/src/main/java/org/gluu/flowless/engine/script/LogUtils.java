package org.gluu.flowless.engine.script;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);
    //MUST be a single character string
    private static final String PLACEHOLDER = "%";

    private static final int MAX_ITERABLE_ITEMS = ScriptUtils.managedBean(EngineConfig.class)
            .getMaxItemsLoggedInCollections();
    
    private enum LogLevel { 
        //Names must match those of org.apache.logging.log4j.Level
        ERROR, WARN, INFO, DEBUG, TRACE;
        
        String getValue() {
            return toString().toLowerCase();
        }

    }
    
    /**
     * rest has at least 1 element
     * @param rest 
     */
    public static void log(Object ...rest) {
    
        LogLevel level;
        int dummyArgs = 0;
        String sfirst;
        int nargs = rest.length - 1;

        Object first = rest[0];
        if (first != null && first instanceof String) {
            Pair<LogLevel, String> p = getLogLevel(first.toString());
            level = p.getFirst();

            if (ignoreLogStatement(level)) return;
            
            Pair<String, Integer> q = getFormatString(p.getSecond(), nargs);
            sfirst = q.getFirst();
            dummyArgs = q.getSecond();
            
        } else {
            level = LogLevel.INFO;
            
            if (ignoreLogStatement(level)) return;
            
            sfirst = asString(first) + getFormatString("", nargs).getFirst();
        }

        Object[] args = new String[nargs + dummyArgs];
        for (int i = 0; i < nargs; i++) {
            args[i] = asString(rest[i + 1]);
        }
        Arrays.fill(args, nargs, args.length, "");
        String result = String.format(sfirst, args);

        switch (level) {
            case ERROR:
                LOG.error(result);
                break;
            case WARN:
                LOG.warn(result);
                break;
            case INFO:
                LOG.info(result);
                break;
            case DEBUG:
                LOG.debug(result);
                break;
            case TRACE:
                LOG.trace(result);
                break;
        }
        
    }

    //TODO: integrate to auth-server. In practice the current log level of server should be used
    //instead of resorting to loggercontext usage
    private static Level getAppLogLevel() {
        LoggerContext loggerContext = LoggerContext.getContext(false);
        return loggerContext.getConfiguration().getLoggerConfig("org.gluu.flowless").getLevel();
    }
    
    private static boolean ignoreLogStatement(LogLevel logLevel) {
        Level appLevel = Optional.ofNullable(getAppLogLevel()).orElse(Level.INFO);
        Level level = Level.getLevel(logLevel.toString());
        return level.intLevel() > appLevel.intLevel();
        
        //A log request of level p in a logger with level q is enabled if p <= q. 
        //Levels are ordered: ALL > DEBUG > INFO > WARN > ERROR > FATAL > OFF.
        //OFF < FATAL < ERROR < WARN < INFO < DEBUG < ALL
    }
    
    private static Pair<LogLevel, String> getLogLevel(String first) {

        LogLevel level = null;
        String newFirst = null;

        String suffix = " ";
        if (first.startsWith("@")) {
            level = Stream.of(LogLevel.values()).filter(
                    l -> {
                        String lev = l.getValue();
                        return first.startsWith("@" + lev.substring(0, 1) + suffix) 
                            || first.startsWith("@" + lev + suffix);
                    }
            ).findFirst().orElse(null);

            if (level != null) {
                int levLen = first.substring(2).startsWith(suffix) ? 1 : level.getValue().length();
                newFirst = first.substring(1 + levLen + suffix.length());
            }
        }
        
        if (level == null) {
            newFirst = first;
            level = LogLevel.INFO;
        }
        return new Pair<>(level, newFirst);
                
    }

    private static Pair<String, Integer> getFormatString(String str, int nargs) {
    
        Integer dummyArgs = 0;
        String tmp = str.replace(PLACEHOLDER, "%s");
        int existingPlaceHolders = tmp.length() - str.length();
        
        if (existingPlaceHolders > 0) {
            int excess = existingPlaceHolders - nargs; 
            if (excess < 0) {
                tmp += " %s".repeat(-excess);
            } else {
                dummyArgs = excess;
            }
        } else {
            tmp = str + " %s".repeat(nargs);
        }
        return new Pair<>(tmp, dummyArgs);
        
    }
    
    private static String subCollectionAsString(Collection<?> col) {
        
        int len = col.size();
        int count = Math.min(len, MAX_ITERABLE_ITEMS);
        Iterator iterator = col.iterator();
        StringBuilder sb = new StringBuilder("[");
        
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                sb.append(asString(iterator.next())).append(", ");
            }
            if (len > count) {
                sb.append("...").append(len - count).append(" more");
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.append("]").toString();
        
    }

    private static String asString(Object obj) {
        
        if (obj == null) return "null";
        Class<?> objCls = obj.getClass();
        
        //JS-native numeric values always come as doubles; make them look like integers if that's the case
        if (objCls.equals(Double.class)) {
            Double d = (Double) obj;
            if (Math.floor(d) == d && d >= 1.0*Long.MIN_VALUE && d <= 1.0*Long.MAX_VALUE) {
                return Long.toString(d.longValue());
            }
        } else if (objCls.isArray()) {
            
            List<Object> list = new ArrayList<>();
            for (int i = 0; i <= MAX_ITERABLE_ITEMS; i++) { //Allows one extra element
                try {
                    list.add(Array.get(obj, i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            return subCollectionAsString(list);
            
        } else if (Collection.class.isInstance(obj)) {
            return subCollectionAsString((Collection) obj);  
            
        } else if (Map.class.isInstance(obj)) {
            
            Map map = (Map) obj;
            List<AbstractMap.SimpleImmutableEntry> entries = new ArrayList<>();
            int i = 0;

            for (Object key : map.keySet()) {                
                entries.add(new AbstractMap.SimpleImmutableEntry(key, map.get(key)));
                if (++i > MAX_ITERABLE_ITEMS) break; //Allows one extra element
            }
            return subCollectionAsString(entries);
            
        } else if (Map.Entry.class.isInstance(obj)) {
            Map.Entry e = (Map.Entry) obj;
            return String.format("(%s: %s)", asString(e.getKey()), asString(e.getValue()));
            
        } else if (Throwable.class.isInstance(obj)) {
            Throwable t = (Throwable) obj;
            try(
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw)) {
                
                t.printStackTrace(pw);
                return sw.toString();
            } catch(IOException e) {
                //can be ignored
            }
        }
        return obj.toString();

    }
    
}
