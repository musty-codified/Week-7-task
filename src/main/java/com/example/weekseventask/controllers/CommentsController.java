package com.example.weekseventask.controllers;

import com.example.weekseventask.pojos.CommentDTO;
import com.example.weekseventask.pojos.response.CommentResponseDTO;
import com.example.weekseventask.services.CommentServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CommentsController {
    private final CommentServices commentServices;

    @PostMapping("/create-comment")
    public String createComment(@ModelAttribute CommentDTO commentDTO) {
        commentServices.create(commentDTO);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentServices.delete(id);
        return "index";
    }

    @PostMapping("/edit-comment")
    public String editComment(@ModelAttribute CommentResponseDTO commentResponse) {
        commentServices.update(commentResponse);
        return "index";
    }

    @GetMapping("/like-post/{commentId}{userId}")
    public String likeUnlikeComment(@PathVariable Long commentId, @PathVariable Long userId) {
        commentServices.likeUnlikeComment(commentId, userId);
        return "index";
    }
}
