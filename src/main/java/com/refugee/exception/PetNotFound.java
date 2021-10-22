package com.refugee.exception;

public class PetNotFound extends RuntimeException {
    public PetNotFound(String message) {
        super(message);
    }
}