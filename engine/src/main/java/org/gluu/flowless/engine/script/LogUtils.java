package org.gluu.flowless.engine.script;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.gluu.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);
    //MUST be a single character string
    private static final String PLACEHOLDER = "%";
    
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
        
        String[] args = new String[nargs + dummyArgs];
        //TODO: remove traces
        for (int i = 0; i < nargs; i++) {
            args[i] = asString(rest[i + 1]);
            LOG.trace(Optional.ofNullable(rest[i + 1]).map(o -> o.getClass().getName()).orElse("null"));
        }
        Arrays.fill(args, nargs, args.length, "");
        String result = String.format(sfirst, args);
        
        //LOG.trace(sfirst); 
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


    private static String asString(Object obj) {
        return Optional.ofNullable(obj).map(Object::toString).orElse("null");
    }
    
}
