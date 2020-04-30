package com.edu.neu.zadymicrocommon.exception;

public class NoAuthException extends RuntimeException {
    public NoAuthException(String msg){
        super(msg);
    }
}
