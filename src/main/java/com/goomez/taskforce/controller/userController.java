package com.goomez.taskforce.controller;

import com.goomez.taskforce.dao.userDao;
import com.goomez.taskforce.entity.userEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/controller")
public class userController {
    @Autowired
    userDao dao;

    // método para enviar os Dados para o dataBase
    @PostMapping("/cadastrar")
    public String cadastrar(userEntity user, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/page/error";
        }
        dao.save(user);
        return "redirect:/page/login";
    }
    @PostMapping("/logar")
    public String logar(userEntity user, Model model, HttpServletResponse  response){
        userEntity userLogado = this.dao.login(user.getEmail(),user.getPassword(),user.getUsername());
        if (userLogado != null) {
            new cookieController().set(userLogado.getUsername(),userLogado.getSexo(), response);
            model.addAttribute("userName", userLogado.getUsername());
            return  "redirect:/page/";
        }
        return "redirect:/page/error";
    }
    @GetMapping("/deletAll")
    public String deleteAll(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "redirect:/page/login";
    }
}
