package com.example.weekseventask;

import com.example.weekseventask.repository.PostLikeRepository;
import com.example.weekseventask.repository.UserRepository;
import com.example.weekseventask.services.PostServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class WeekSevenTaskApplicationTests {

	@Mock
	PostServices postServicesMock;
	@Mock
	PostLikeRepository postLikeRepositoryMock;
	@InjectMocks
	UserRepository userRepository;

	@Test
	void contextLoads() {
		System.out.println(postServicesMock.getAllPostsByUserId(1L));
	}

}
