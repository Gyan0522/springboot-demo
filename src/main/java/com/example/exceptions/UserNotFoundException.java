package com.example.exceptions;

public class UserNotFoundException extends Exception {
    
    private static final long serialVersionID = 1l;

    public UserNotFoundException(String message){
        super(message);

    }
}
