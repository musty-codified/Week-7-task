package com.example.weekseventask.repository;

import com.example.weekseventask.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
