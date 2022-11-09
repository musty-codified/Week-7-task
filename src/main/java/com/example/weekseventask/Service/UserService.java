package com.example.weekseventask.Service;

import com.example.weekseventask.model.User;


public interface UserService {

    public User createUser(User user);

    public boolean checkEmail(String email);
}
