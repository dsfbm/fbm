package com.example.exception;

import com.example.response.ErrorResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

import java.awt.*;
import java.util.Map;


public class ControllerExceptionHandler implements ErrorController {
   //用途解析异常
    private ErrorAttributes errorAttribute;
    @Autowired
    private ServerProperties serverProperties;
    @Autowired
    public ControllerExceptionHandler(ErrorAttributes errorAttribute){
        Assert.notNull(errorAttribute,"ErrorAttributes 不能为null");
        this.errorAttribute=errorAttribute;
    }
    @RequestMapping("/error")
    public ErrorResponseData error(HttpServletRequest request){
        Map<String,Object> body=getErrorAttributs(request,isIncludeStackTrace(request,MediaType.ALL));

        HttpStatus status=getStatus(request);
        return new ErrorResponseData((Integer) status.value(),body.get("message").toString());

    }
    private HttpStatus getStatus(HttpServletRequest request){
            Integer StatusCode=(Integer) request.getAttribute("javax.servlet.error.status.code");
        if (StatusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }try{
            return HttpStatus.valueOf(StatusCode);

        }catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    private Map<String,Object> getErrorAttributs(HttpServletRequest request,boolean includeStackTrace){
        ServletWebRequest requestAttributes=new ServletWebRequest(request);
        return this.errorAttribute.getErrorAttributes(requestAttributes,includeStackTrace);


    }

    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produes){
        ErrorProperties.IncludeStacktrace includes=this.serverProperties.getError().getIncludeStacktrace();
        if (includes==ErrorProperties.IncludeStacktrace.ALWAYS){
            return true;


        }
        if (includes==ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM){
            return getTraceParamter(request);

            }
        return false;


    }

    private boolean getTraceParamter(HttpServletRequest request){

            String parameter=request.getParameter("trace");

            if (parameter==null){

                return false;
            }
            return !"false".equals(parameter.toLowerCase());
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
