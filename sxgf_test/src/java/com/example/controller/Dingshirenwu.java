package com.example.controller;

import com.example.entity.User;
import com.example.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Controller
@RequestMapping("/")
public class Dingshirenwu {
    @Autowired
    private UserSerice userSerice;

    @RequestMapping ( "/dignshi")
    @ResponseBody
    public void aaa() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("开始执行定时任务。。。。。。。:" + new Date());


                for (User aa: userSerice.findAll()) {
                    System.out.println(aa);

                }
            }
        };

        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
        timer.schedule(timerTask, 10, 3000);
    }


}





