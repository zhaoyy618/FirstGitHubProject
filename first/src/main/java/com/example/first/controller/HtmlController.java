package com.example.first.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api("html")
public class HtmlController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
