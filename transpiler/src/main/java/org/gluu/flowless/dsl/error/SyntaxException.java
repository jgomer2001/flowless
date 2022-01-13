package org.gluu.flowless.dsl.error;

import java.util.Optional;
import java.util.function.Function;

public class SyntaxException extends Exception {

    private String message;
    private String symbol;
    private int line;
    private int column;

    public SyntaxException() {
    }
    
    public SyntaxException(String message, String symbol, int line, int column) {
        this.message = message;
        this.symbol = symbol;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public String getMessage() {
        
        String msg = "Syntax error: ";
        msg += Optional.ofNullable(message).map(Function.identity()).orElse("");
        msg += Optional.ofNullable(symbol).map(s -> String.format("\nSymbol: %s", s)).orElse("");
        msg += String.format("\nLine: %d", line);
        msg += String.format("\nColumn: %d", column + 1);
        return msg;

    }

    /**
     * @return the message
     
    public String getMessage() {
        return message;
    }*/

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }
    
}
