package com.example.weekseventask.controllers;

import com.example.weekseventask.pojos.PostDTO;
import com.example.weekseventask.pojos.response.PostResponseDTO;
import com.example.weekseventask.pojos.response.UserResponseDTO;
import com.example.weekseventask.services.PostServices;
import com.example.weekseventask.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PostsController {
    private PostServices postServices;
    private UserServices userServices;
    @PostMapping("/create-post")
    public ModelAndView createPost(@ModelAttribute PostDTO postDTO, Model model) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try {
            postServices.create(postDTO);
        } catch (Exception e) {
            model.addAttribute("createPostError", e.getMessage());
        }

        ModelAndView mav = new ModelAndView("index");

        userResponseDTO.setId(postDTO.getUser_id());
        userResponseDTO.setFirstname(postDTO.getAuthor());
        userResponseDTO.setUserPosts(postServices.getAllPostsByUserId(postDTO.getUser_id()));
        model.addAttribute("createPostSuccess", "Post created successfully");
        mav.addObject("user", userResponseDTO);

        return mav;
    }

    @PostMapping("edit-post")
    public String editPost(@ModelAttribute PostResponseDTO postResponseDTO) {
        postServices.update(postResponseDTO);
        return "index";
    }

    @GetMapping("/delete-post")
    public ModelAndView deletePost(@RequestParam(value = "postId") Long postId, @RequestParam(value = "userId") Long userId) {
        postServices.delete(postId);

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        ModelAndView mav = new ModelAndView("index");

        userResponseDTO.setId(userId);
        userResponseDTO.setFirstname(userServices.getUserById(userId).getFirstname());
        userResponseDTO.setUserPosts(postServices.getAllPostsByUserId(userId));
        mav.addObject("user", userResponseDTO);

        return mav;
    }

    @GetMapping("/like-post/{postId}{userId}")
    public String likeUnlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        postServices.likeUnlikePost(postId, userId);
        return "index";
    }
}
