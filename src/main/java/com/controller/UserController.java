package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    /**
     * 测试方法
     */

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("userController.hello()");
        return "ok";
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/unAuth")
    public String unAuth(){
        return "/unAuth";
    }

    /**
     * 测试thymeleaf
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name","tyttpe");
        //返回test.html
        return "test";
    }



    /**
     * 登录逻辑处理
     */
    @RequestMapping("/login")
    public String login(String name,String password,Model model){

        /**
         * 使用shiro编写认证操作
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功
            //跳转test.html
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
//            e.printStackTrace();
            //登录失败，用户不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
//            e.printStackTrace();
            //登录失败，密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
