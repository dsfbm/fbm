package com.example.exception;

import com.example.response.ErrorResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class DdviceExceptionHandler {


    /**
     * 拦截系统异常
     */
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody              //这个exception是如何给他传值的？
    public ErrorResponseData system(SystemException exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(ServiceExcption.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData service(ServiceExcption exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(ParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData param(ParameterException exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }


}