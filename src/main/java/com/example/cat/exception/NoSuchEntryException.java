package com.example.cat.exception;



public class NoSuchEntryException extends RuntimeException{
    public NoSuchEntryException() {
        super("No such database entry");
    }
    public NoSuchEntryException(String message) {
        super(message);
    }
}
