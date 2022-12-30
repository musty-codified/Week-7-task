package com.example.weekseventask.repository;


import com.example.weekseventask.models.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLikes, Long> {

    PostLikes findPostLikesByPostIdAndUserId(Long post_id, Long user_id);


    List<PostLikes> findPostLikesByPostId(Long post_id);
}
