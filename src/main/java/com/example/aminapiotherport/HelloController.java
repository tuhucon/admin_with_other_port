package com.example.aminapiotherport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/adm/hello")
    public String helloAdmin() {
        return "hello Admin";
    }

}
