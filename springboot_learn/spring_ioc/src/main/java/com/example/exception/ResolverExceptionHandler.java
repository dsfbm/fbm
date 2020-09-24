package com.example.exception;

import com.example.response.ErrorResponseData;
import com.example.response.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class ResolverExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv;
        if (e instanceof ParameterException) {
            mv=new ModelAndView(new MappingJackson2JsonView(),new ErrorResponseData(((ParameterException) e).getCode(),e.getMessage()).toMap());

        }else {

            mv=new ModelAndView(new MappingJackson2JsonView(),new ErrorResponseData((ResponseData.DEFAULT_ERROR_MESSAGE)).toMap());
        }
        return mv;
    }
}

