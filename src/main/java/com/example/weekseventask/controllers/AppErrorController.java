package com.example.weekseventask.controllers;

import com.example.weekseventask.pojos.UserDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController {

    private final static String PATH = "/error";

    @RequestMapping(PATH)
    public String getErrorPath(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }
}
