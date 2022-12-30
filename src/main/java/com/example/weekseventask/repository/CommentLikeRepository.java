package com.example.weekseventask.repository;

import com.example.weekseventask.models.CommentLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentLikeRepository extends JpaRepository<CommentLikes, Long> {

    CommentLikes findCommentLikesByCommentIdAndUserId(Long comment_id, Long user_id);

    List<CommentLikes> findCommentLikesByCommentId(Long comment_id);
}
