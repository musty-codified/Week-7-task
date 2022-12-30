package com.example.weekseventask.services;

import com.example.weekseventask.repository.PostLikeRepository;
import com.example.weekseventask.repository.PostRepository;
import com.example.weekseventask.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class PostServicesTest {

    @Mock
    PostRepository postRepositoryMock;
    @Mock
    PostLikeRepository postLikeRepositoryMock;
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    PostServicesTest postServicesTest;

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void likeUnlikePost() {
    }
}