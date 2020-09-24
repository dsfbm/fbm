package com.example.controller;

import com.example.entity.DiGuiVo;
import com.example.entity.User;
import com.example.service.DiguiServiceImpi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DiguiController {
    @Autowired
    private DiguiServiceImpi diguiServiceImpi;

    //添加一个用户
    @ApiOperation(value="添加一个用户", notes="输入信息即可添加成功")
    @PostMapping( "/findByRootId")
    @ResponseBody
    public DiGuiVo findByRootId(Integer id) {

        return diguiServiceImpi.findByRootId(id);

    }

}
