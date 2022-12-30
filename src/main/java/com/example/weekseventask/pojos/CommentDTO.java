package com.example.weekseventask.pojos;

import lombok.Data;

@Data
public class CommentDTO {

    private Long postId;
    private Long commenterId;
    private String commenterName;
    private String commentContent;
}
