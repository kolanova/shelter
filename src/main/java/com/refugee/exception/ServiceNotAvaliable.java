package com.refugee.exception;

public class ServiceNotAvaliable extends RuntimeException{
    public ServiceNotAvaliable(String message) {
        super(message);
    }
}
