package com.cuiyq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }
}
