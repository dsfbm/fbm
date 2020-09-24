package com.example.hot.exception;



public class SystemException extends RuntimeException {

    private Integer code;
    private String errorMessage;

    public SystemException(Integer code,String errorMessage){
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public SystemException(AbstraceBaseExceptionEnum exception){
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
