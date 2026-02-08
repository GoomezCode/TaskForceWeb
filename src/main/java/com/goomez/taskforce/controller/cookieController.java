package com.goomez.taskforce.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cookie")
public class cookieController {
    @GetMapping("/set")
    public String set(@RequestParam(value = "username") String username, @RequestParam(value = "sexo")String sexo, HttpServletResponse response){
        Cookie cookieUsername = new Cookie("username", username);
        cookieUsername.setMaxAge(2629800);
        cookieUsername.setSecure(true);
        cookieUsername.setHttpOnly(true);
        cookieUsername.setPath("/");
        Cookie cookieSexo = new Cookie("sexo", sexo);
        cookieSexo.setMaxAge(2629800);
        cookieSexo.setSecure(true);
        cookieSexo.setHttpOnly(true);
        cookieSexo.setPath("/");

        response.addCookie(cookieUsername);
        response.addCookie(cookieSexo);
        return "set";
    }
    @GetMapping("/get")
    public String get(@CookieValue(value = "username") String username, @CookieValue(value = "sexo") String sexo){

        return "data User | username:"+username+" | sexo:"+sexo;
    }
    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    @GetMapping("/getAll")
    public List getAll(HttpServletRequest request){
        List list = new ArrayList();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            list.addAll(Arrays.asList(cookies));
        }
        return list;
    }
    @GetMapping("/delet")
    public String delete(HttpServletResponse response){
        Cookie deletUsername = new Cookie("username", null);
        deletUsername.setMaxAge(0);
        deletUsername.setPath("/");
        Cookie deletSexo = new Cookie("sexo", null);
        deletSexo.setMaxAge(0);
        deletSexo.setPath("/");
        response.addCookie(deletUsername);
        response.addCookie(deletSexo);
        return "delete";
    }

}
