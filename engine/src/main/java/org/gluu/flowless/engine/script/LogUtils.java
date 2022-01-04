package org.gluu.flowless.engine.script;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.enterprise.inject.spi.CDI;

import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.util.Pair;
import org.mozilla.javascript.NativeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);
    //MUST be a single character string
    private static final String PLACEHOLDER = "%";
    
    //TODO: use oxcore-util
    private static final int MAX_ITERABLE_ITEMS = CDI.current().select(EngineConfig.class).get()
            .getMaxItemsLoggedInCollections();
    
    private enum LogLevel { 
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
    
        LogLevel level = null;
        int dummyArgs = 0;
        String sfirst;
        int nargs = rest.length - 1;

        Object first = rest[0];
        if (first != null && first instanceof String) {
            Pair<LogLevel, String> p = getLogLevel(first.toString());
            level = p.getFirst();
            
            Pair<String, Integer> q = getFormatString(p.getSecond(), nargs);
            sfirst = q.getFirst();
            dummyArgs = q.getSecond();
            
        } else {
            sfirst = asString(first) + getFormatString("", nargs).getFirst();
        }
        
        Object[] args = new String[nargs + dummyArgs];
        for (int i = 0; i < nargs; i++) {
            args[i] = asString(rest[i + 1]);
        }
        Arrays.fill(args, nargs, args.length, "");
        String result = String.format(sfirst, args);
        
        if (level == null) {
            level = LogLevel.INFO;
        }
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
                newFirst = first.substring(1 + level.getValue().length() + suffix.length());
            }
        }
        
        if (level == null) {
            newFirst = first;
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
        
        //JS-native numeric values always come as doubles; make them look like integers if that's the case
        if (obj.getClass().equals(Double.class)) {
            Double d = (Double) obj;
            if (Math.floor(d) == d && d >= 1.0*Integer.MIN_VALUE && d <= 1.0*Integer.MAX_VALUE) {
                return Integer.toString(d.intValue());
            }
        } else if (obj.getClass().isArray()) {
            
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < MAX_ITERABLE_ITEMS; i++) {
                try {
                    list.add(Array.get(obj, i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            return subCollectionAsString(list);
            
        } else if (Collection.class.isInstance(obj)) {
            return subCollectionAsString((Collection) obj);  
            
        } else if (NativeObject.class.isInstance(obj)) {
            //Avoid the undesirable [object Object] JS way of printing objects
            return ((Map) obj).toString();
        }
        return obj.toString();

    }
    
}
