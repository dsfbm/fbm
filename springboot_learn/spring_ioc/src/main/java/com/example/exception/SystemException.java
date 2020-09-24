package com.example.exception;

import com.example.data.AbstraceBaseExceptionEnum;
/*
它继承这个类做了什么？

 */


public class SystemException extends RuntimeException{
        private Integer code;
        private String ErrorMessage;
        public SystemException(Integer code,String errorMessage){
            super(errorMessage);
            this.code=code;
            this.ErrorMessage=errorMessage;

        }
        //   exceptiom里接收到的是：SYSREM_ERROR 枚举  在这之前已经将枚举里的属性传递给对应的变量里了
        //   问题：为啥可以从这里调用属性
        public SystemException(AbstraceBaseExceptionEnum exception){
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
