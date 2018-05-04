package com.terms.config;


public class MailErrorException extends RuntimeException {

    private String msg;

    public MailErrorException(String msg) {
        this.msg = msg;
    }

    public void messageError(String msg){
        this.msg = msg;
    }

    public String gerMsg(){
        return this.msg;
    }
}
