package org.gluu.flowless.dsl.error;

//import java.util.Optional;
//import java.util.function.Function;

public class SyntaxException extends Exception {

    private String message;
    private String symbol;
    private int line;
    private int column;

    public SyntaxException() {
    }
    
    public SyntaxException(String message, String symbol, int line, int column) {
        setMessage(message);
        setSymbol(symbol);
        setLine(line);
        setColumn(column);
    }
    /*
    @Override
    public String getMessage() {
        String msg = "Syntax error: ";
        msg += Optional.ofNullable(message).map(Function.identity()).orElse("");
        return msg;        
    }
*/
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

}
