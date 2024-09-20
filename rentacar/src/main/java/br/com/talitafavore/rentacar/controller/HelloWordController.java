package br.com.talitafavore.rentacar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {

    @GetMapping
    public String welcome(){
        return "Hello World";
    }
}
