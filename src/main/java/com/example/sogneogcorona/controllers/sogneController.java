package com.example.sogneogcorona.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sogneController {

    @GetMapping("/")

    public String index (){

        return "index";
    }
}
