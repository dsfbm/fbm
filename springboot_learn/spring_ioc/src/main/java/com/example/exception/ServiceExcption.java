package com.example.exception;

import com.example.data.AbstraceBaseExceptionEnum;

public class ServiceExcption extends RuntimeException{
    private Integer code;
    private String ErrorMessage;
    public ServiceExcption(Integer code,String errorMessage){
        super(errorMessage);
        this.code=code;
        this.ErrorMessage=errorMessage;

    }

    public ServiceExcption(AbstraceBaseExceptionEnum exception){
        super(exception.getMessage());
        this.code=exception.getCode();
        this.ErrorMessage=exception.getMessage();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }



}
