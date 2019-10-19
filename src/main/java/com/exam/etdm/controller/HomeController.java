package com.exam.etdm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping(value = {"/","/etdm", "/etdm/home"})
    public String home()
    {
        return "index";
    }

}
