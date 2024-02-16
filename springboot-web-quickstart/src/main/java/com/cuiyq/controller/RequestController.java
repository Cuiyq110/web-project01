package com.cuiyq.controller;

import com.cuiyq.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：接收数据返回
 */
@RestController
public class RequestController {

//    老方法
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest requerst) {
        String name = requerst.getParameter("name");
        String age = requerst.getParameter("age");

        System.out.println("name:" + name + ",age:" + age);
        return "name:" + name + ",age:" + age;
    }

//    基于springboot的方法
    @RequestMapping("/simpleParam2")
    public String simpleParam2(@RequestParam(name = "username",required = false) String name, Integer age) {
        System.out.println("name:" + name + ",age:" + age);
        return "name:" + name + ",age:" + age;
    }

//      实体参数
    @RequestMapping("/simpleParam3")
    public String simpleParam3(User user) {
        System.out.println("user:" + user);
        return "user:" + user;
    }
}
