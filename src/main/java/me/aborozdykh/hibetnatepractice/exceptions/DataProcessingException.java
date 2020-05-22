package me.aborozdykh.hibetnatepractice.exceptions;

public class DataProcessingException extends RuntimeException{
    public DataProcessingException(String message){
        super(message);
    }

    public DataProcessingException(String message, Throwable cause){
        super(message, cause);
    }
}
