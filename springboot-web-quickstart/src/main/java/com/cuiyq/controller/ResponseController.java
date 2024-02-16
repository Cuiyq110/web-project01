package com.cuiyq.controller;

import com.cuiyq.domain.Address;
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
    public String Hello1(String name)
    {
        return "Hello1 " + name;
    }

    @RequestMapping("/addr")
    public String getAddr() {
        Address address = new Address();
        address.setProvince("tom");
        address.setCity("北京");
        return address.toString();
    }

    @RequestMapping("/user")
    public String listAddr() {
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setProvince("tom");
        address.setCity("北京");

        Address address1 = new Address();
        address1.setProvince("tom1");
        address1.setCity("北京1");
        addresses.add(address);
        addresses.add(address1);
        return addresses.toString();
    }



}
