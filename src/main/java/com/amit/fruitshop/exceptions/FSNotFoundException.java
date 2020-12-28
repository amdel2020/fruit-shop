package com.amit.fruitshop.exceptions;

public class FSNotFoundException extends RuntimeException{
    public FSNotFoundException(String message) {
        super(message);
    }
}
