package com.cuiyq.controller;

import com.cuiyq.domain.Address;
import com.cuiyq.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@RestController
public class ResponseController {
    @RequestMapping("/hello1")
    public Result Hello1(String name)
    {
//        return "Hello1 " + name;

        return Result.success("Hello");
    }

    @RequestMapping("/addr")
    public Result getAddr() {
        Address address = new Address();
        address.setProvince("tom");
        address.setCity("北京");
//        return address.toString();

        return Result.success(address);
    }

    @RequestMapping("/listaddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();
        Address address = new Address();
        address.setProvince("tom");
        address.setCity("北京");

        Address address1 = new Address();
        address1.setProvince("tom1");
        address1.setCity("北京1");
        list.add(address);
        list.add(address1);
//        return addresses.toString();
        System.out.println(Result.success(list));
        return Result.success(list);
    }



}
