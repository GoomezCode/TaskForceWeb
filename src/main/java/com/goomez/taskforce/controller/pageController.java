package com.goomez.taskforce.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class pageController {

    @GetMapping("/cadastro")
    public String cadastro(HttpServletRequest request) {
        if(new cookieController().getCookieValue(request,"username") != null && new cookieController().getCookieValue(request,"sexo") != null){
            return "redirect:/page/";
        }
        return "cadastro";
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request){
        if(new cookieController().getCookieValue(request,"username") != null && new cookieController().getCookieValue(request,"sexo") != null){
            return "redirect:/page/";
        }
        return "login";
    }
    @GetMapping("/error")
    public String error(){return "error";}

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        if(new cookieController().getCookieValue(request,"username") != null && new cookieController().getCookieValue(request,"sexo") != null){
            model.addAttribute("userName",new cookieController().getCookieValue(request,"username"));
            return "index";
        }
        return "redirect:/page/login";
    }
}
