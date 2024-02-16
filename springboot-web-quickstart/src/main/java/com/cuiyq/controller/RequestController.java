package com.cuiyq.controller;


import com.cuiyq.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

//  复杂实体参数
    @RequestMapping("/complexParam")
    public String complexParam(User user) {
        System.out.println("user:" + user);
        return "user:" + user;
    }

//    数组和集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println("hobby:" + Arrays.toString(hobby));
        return "hobby:" + hobby;
    }

    @RequestMapping("/listParam")
    public String ListParam(@RequestParam List<String> hobby) {
        System.out.println("hobby:" + hobby);
        return "hobby:" + hobby;
    }

//    日期参数
    @RequestMapping("/dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println("updateTime:" + updateTime);
        return "updateTime:" + updateTime;
    }

//    json参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println("user:" + user);
        return "user:" + user;
    }

//    路径参数
    @RequestMapping("/pathParam/{userId}")
    public String pathParam(@PathVariable("userId") String userId) {
        System.out.println("userId:" + userId);
        return "userId:" + userId;
    }


    //    路径参数
    @RequestMapping("/pathParam/{userId}/{name}")
    public String pathParam(@PathVariable String userId, @PathVariable String name) {
        System.out.println("userId:" + userId + ",name:" + name);
        return "userId:" + userId + ",name:" + name;
    }
}
