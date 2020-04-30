package com.edu.neu.zadymicrocommon.exception;

//数据有错，可以为空，也可以是外键约束没有之类的。
public class DegradeException extends RuntimeException {
    public DegradeException(String msg){
        super(msg);
    }
}
