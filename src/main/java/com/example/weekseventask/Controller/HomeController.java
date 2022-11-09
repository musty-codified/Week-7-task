package com.example.weekseventask.Controller;

import com.example.weekseventask.Service.UserService;
import com.example.weekseventask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute User user, HttpSession session) {

        // System.out.println(user);

        boolean f = userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id already exists");
        }

        else {
            User users = userService.createUser(user);
            if (users != null) {
                session.setAttribute("msg", "Registration  Successful");
            } else {
                session.setAttribute("msg", "Something went wrong");
            }
        }

        return "redirect:/register";
    }
}
