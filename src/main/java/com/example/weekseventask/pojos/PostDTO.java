package com.example.weekseventask.pojos;

import lombok.Data;

@Data
public class PostDTO {
    private Long user_id;
    private String author;
    private String postContent;
}
