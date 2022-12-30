package com.example.weekseventask.services;

import com.example.weekseventask.models.User;
import com.example.weekseventask.pojos.UserDTO;
import com.example.weekseventask.pojos.response.UserResponseDTO;
import com.example.weekseventask.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    @Mock
    UserRepository userRepositoryMock;
    @Mock
    PostServices postServicesMock;
    @Mock
    UserDTO userDtoMock;
    @Mock
    UserResponseDTO userResponseDtoMock;
    @Mock
    User userMock;

    @InjectMocks
    UserServices userServices;



    @BeforeEach
    void setUp() {
        when(userDtoMock.getEmail()).thenReturn("austin@gmail.com");
        when(userDtoMock.getPassword()).thenReturn("1234");
        when(userMock.getId()).thenReturn(1L);
    }

    @Test
    void registerUser() {

        when(userDtoMock.getConfirmpassword()).thenReturn("1234");
        when(userRepositoryMock.findByEmailContaining(userDtoMock.getEmail())).thenReturn(null);

        assertThat(userServices.registerUser(userDtoMock).getEmail(), is(equalTo("austin@gmail.com")));
    }

    @Test
    void loginUser() {
        when(userRepositoryMock.findByEmailContaining(userDtoMock.getEmail())).thenReturn(userMock);
        when(userMock.getPassword()).thenReturn("1234");
        when(userResponseDtoMock.getId()).thenReturn(1L);
        when(postServicesMock.getAllPostsByUserId(userResponseDtoMock.getId())).thenReturn(new ArrayList<>());

        assertThat(userServices.loginUser(userDtoMock), is(notNullValue()));
    }

}