package com.example.weekseventask.controllers;

import com.example.weekseventask.pojos.CommentDTO;
import com.example.weekseventask.pojos.PostDTO;
import com.example.weekseventask.pojos.UserDTO;
import com.example.weekseventask.pojos.response.UserResponseDTO;
import com.example.weekseventask.services.PostServices;
import com.example.weekseventask.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserServices userServices;
    private final PostServices postServices;

    @GetMapping("/index")
    public String home() {

        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register-user")
    public String registerUser(UserDTO userDto, BindingResult result, Model model) {

        if (result.hasErrors()) return "register";

        UserResponseDTO userResponse = userServices.registerUser(userDto);
        if (userResponse == null) {
            model.addAttribute("registrationError", "password does not match or Email already exists");
            return "register";
        }
        model.addAttribute("postDTO", new PostDTO());
        model.addAttribute("user", userResponse);

        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping("/login-user")
    public String loginUser(@ModelAttribute UserDTO userDTO, Model model) {
        UserResponseDTO userResponse = userServices.loginUser(userDTO);


        if (userResponse == null) {
            model.addAttribute("loginError", "invalid password or email");
            return "login";
        }
        model.addAttribute("postDTO", new PostDTO());
        model.addAttribute("commentDTO", new CommentDTO());
        model.addAttribute("user", userResponse);
//        redirectAttributes.addFlashAttribute("model", model);

        return "index";
    }
}
