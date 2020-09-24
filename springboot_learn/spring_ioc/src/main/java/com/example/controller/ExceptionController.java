package com.example.controller;

import com.example.data.ParameterExceptionEnum;
import com.example.data.ServiceExceptionEnum;
import com.example.data.SystemExceptionEnum;
import com.example.exception.ParameterException;
import com.example.exception.ServiceExcption;
import com.example.exception.SystemException;
import com.example.response.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@ResponseBody
public class ExceptionController {
    @RequestMapping("system")
    public ResponseData system(){
        throw new SystemException(SystemExceptionEnum.SYSTEM_ERROR);


    }
    @RequestMapping("/service")
    public ResponseData service(){
        throw new ServiceExcption(ServiceExceptionEnum.NO_THIS_USER);
    }

    @RequestMapping("/param")
    public ResponseData param(){
        throw new ParameterException(ParameterExceptionEnum.PARAM_NOT_NULL);
    }


}
