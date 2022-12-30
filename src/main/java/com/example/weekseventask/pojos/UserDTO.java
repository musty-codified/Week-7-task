package com.example.weekseventask.pojos;

import lombok.Data;

@Data
public class UserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String dob;
    private String sex;
    private String password;
    private String confirmpassword;
}
