package com.springboot.project.Controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping( value = "/" ,method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome to Spring Boot Rest Api !!!!";
    }

}
