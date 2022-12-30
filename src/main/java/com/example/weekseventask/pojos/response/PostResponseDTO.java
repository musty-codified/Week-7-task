package com.example.weekseventask.pojos.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostResponseDTO {
    private Long id;
    private Long user_id;
    private Date dateCreated;
    private String author;
    private String postContent;
    private List<Long> postLikes;
    private List<CommentResponseDTO> postComments;
}
