package com.RESTful_API.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvdiboy on 10/20/17.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Welcome the Rudy's Restful API application!";
    }
}
