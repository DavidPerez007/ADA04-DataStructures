package Exceptions;
/**
 * Exception class to catch in different situations, mostly used when there exists a List overflow
 * 
 */

public class LinkException extends Exception{
    private String message;

    public LinkException(String message){
        super(message);
    }
}
