package com.example.weekseventask.pojos.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private List<PostResponseDTO> userPosts;
    private String email;
}
