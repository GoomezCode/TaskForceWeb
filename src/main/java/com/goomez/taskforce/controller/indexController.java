package com.goomez.taskforce.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping()
    public String index(HttpServletRequest request, Model model) {
        if(new cookieController().getCookieValue(request,"username") != null && new cookieController().getCookieValue(request,"sexo") != null){
            model.addAttribute("userName",new cookieController().getCookieValue(request,"username"));
            return "index";
        }
        return "redirect:/page/login";
    }
}
