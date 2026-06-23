package com.example.primeiroAppSpring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping ("/helloword")
    public String exibirMensagem() {
        return "<h1>Hello Word</h1>" +
                "<p>Meu primeiro app Spring Boot.</p>";
    }

}
