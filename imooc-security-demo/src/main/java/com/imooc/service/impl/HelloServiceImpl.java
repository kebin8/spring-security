package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 2017/11/28.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "Hello " + name;
    }
}