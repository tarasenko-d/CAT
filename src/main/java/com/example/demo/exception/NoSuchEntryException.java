package com.example.demo.exception;

public class NoSuchEntryException extends RuntimeException{
    public NoSuchEntryException() {
        super("No such database entry");
    }
}
