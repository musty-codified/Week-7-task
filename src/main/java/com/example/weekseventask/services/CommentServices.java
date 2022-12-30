package com.example.weekseventask.services;

import com.example.weekseventask.models.Comment;
import com.example.weekseventask.models.CommentLikes;
import com.example.weekseventask.pojos.CommentDTO;
import com.example.weekseventask.pojos.response.CommentResponseDTO;
import com.example.weekseventask.repository.CommentLikeRepository;
import com.example.weekseventask.repository.CommentRepository;
import com.example.weekseventask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServices {

    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final UserRepository userRepository;

    public void create(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
//        commentRepository.save(comment);
    }

    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void update(CommentResponseDTO commentResponseDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentResponseDTO,comment);
//        commentRepository.save(comment);
    }

    public void likeUnlikeComment(Long commentId, Long userId) {
        CommentLikes commentLikes = null;
        if ((commentLikes = commentLikeRepository.findCommentLikesByCommentIdAndUserId(commentId,userId)) == null) {

            CommentLikes clikes = new CommentLikes();
            clikes.setUser(userRepository.findById(userId).get());
            clikes.setComment((Comment) commentRepository.findById(commentId).get());
            commentLikeRepository.save(clikes);
        } else {
            commentLikeRepository.deleteById(commentLikes.getId());
        }
    }

    public List<Long> getAllCommentLikers(Comment comment) {
        return comment.getCommentLikes().stream()
                .map(like -> like.getUser().getId())
                .collect(Collectors.toList());
    }


}
