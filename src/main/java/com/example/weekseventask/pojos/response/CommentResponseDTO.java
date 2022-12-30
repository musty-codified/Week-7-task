package com.example.weekseventask.pojos.response;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CommentResponseDTO {
    private Long id;
    private Long postId;
    private Long commenterId;
    private Date dateCreated;
    private String commenterName;
    private String commentContent;
    private List<Long> commentLikes;
}
