package com.example.messageService.utils;

public class UserThrowException extends Exception{
    private String errorMsg;

    public UserThrowException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String responseString() {
        return "new Throwable()";
    }

}
