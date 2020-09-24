package com.qf.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.dto.UserDTO;

import com.qf.pojo.SysUser;
import com.qf.service.SysUserService;
import com.qf.utils1.MD5Utils;
import com.qf.utils1.R;

import com.qf.utils1.ShiroUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Controller
public class UserController {
    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private DefaultKaptcha kaptcha;

    @RequestMapping("/captcha.jpg")
    public void  captcha(HttpServletResponse response){
        //设置缓存
        response.setHeader("Cache-Control","no-store,no-cache");
        //设置相应内容
        response.setContentType("image/jpg");
        //生成验证码

        String text=kaptcha.createText();


        //生成图片
        BufferedImage image=kaptcha.createImage(text);
        //验证码储存到shiro的session
        ShiroUtils.setKaptcha(text);

        try{
            //返回到页面

            ServletOutputStream outputStream=response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);

        }catch (IOException e){
            e.printStackTrace();

        }


    }

    @RequestMapping("/sys/login")
    @ResponseBody
    public R login(@RequestBody UserDTO userDTO){
        //对比验证码
        String serverKaptcha=ShiroUtils.getKaptcha();
        if(!serverKaptcha.equalsIgnoreCase(userDTO.getCaptcha())){
            return R.error("验证码错误");

        }
        Subject subject=SecurityUtils.getSubject();
        String newPass= MD5Utils.md5(userDTO.getPassword(),userDTO.getUsername(),1024);
        UsernamePasswordToken token=new UsernamePasswordToken(userDTO.getUsername(),newPass);
        if (userDTO.isRememberMe()){
            token.setRememberMe(true);

        }

        subject.login(token);


        System.out.println(userDTO.getUsername());
        return  R.ok();
    }
    @RequestMapping("/sys/user/list")
    @ResponseBody
    public DataGridResult findUser(QueryDTO queryDTO){

        return sysUserService.findUserByPage(queryDTO);
    }
    @RequestMapping("/sys/user/export")
    public void exportUser(HttpServletResponse response){
        Workbook workbook = sysUserService.exportUser();
        try {
            //设置响应头
            response.setContentType("application/octet-stream");//所有文件都支持
            String fileName = "员工信息.xls";
            fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename="+fileName);
            //文件下载
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("/logout")
    public String logout(){
        //工具类
        ShiroUtils.logout();
        return "redirect:login.html";
    }

    @RequestMapping("/sys/user/info")
    @ResponseBody
    public R userinfo(){
        //从shiro中获取菜单
        SysUser userEntity=ShiroUtils.getUserEntity();
        return R.ok().put("user",userEntity);

    }


}
