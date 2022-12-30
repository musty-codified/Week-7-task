package com.example.weekseventask.services;

import com.example.weekseventask.models.User;
import com.example.weekseventask.pojos.UserDTO;
import com.example.weekseventask.pojos.response.PostResponseDTO;
import com.example.weekseventask.pojos.response.UserResponseDTO;
import com.example.weekseventask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServices {
    private final UserRepository userRepository;
    private final PostServices postServices;
    public UserResponseDTO registerUser(UserDTO userDto) {

        if (!userDto.getPassword().equals(userDto.getConfirmpassword()) || userRepository.findByEmailContaining(userDto.getEmail()) != null) {
            return null;
        }
        User user =  new User();
        UserResponseDTO userResponse = new UserResponseDTO();
        BeanUtils.copyProperties(userDto,user);

        userRepository.save(user);
        BeanUtils.copyProperties(userDto, userResponse);
        return userResponse;
    }

    public UserResponseDTO loginUser(UserDTO userDTO) {
        User user = userRepository.findByEmailContaining(userDTO.getEmail());
        if (user == null || !(user.getPassword().equals(userDTO.getPassword()))) {
            return null;
        }
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        List<PostResponseDTO> postResponseDTOS = postServices.getAllPostsByUserId(userResponseDTO.getId());
        userResponseDTO.setUserPosts(postResponseDTOS);

        return userResponseDTO;
    }

    public UserResponseDTO getUserById(Long userId) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user = userRepository.findById(userId).get();
        BeanUtils.copyProperties(user,userResponseDTO);
        return userResponseDTO;
    }

}
