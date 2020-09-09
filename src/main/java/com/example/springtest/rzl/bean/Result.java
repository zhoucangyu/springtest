package com.example.springtest.rzl.bean;

public class Result {
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;
    private int code;
    private String message;
    private Object data;

    public int getCode() {return code;}
    public void setCode(int code) {this.code = code;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public Object getData() {return data;}
    public void setData(Object data) {this.data = data;}
}
