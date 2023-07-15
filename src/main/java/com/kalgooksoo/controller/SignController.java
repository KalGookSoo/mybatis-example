package com.kalgooksoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignController {

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

}