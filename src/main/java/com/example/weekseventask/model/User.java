package com.example.weekseventask.model;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Data
@ToString
@Entity
//@Table(name = "users_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String password;

    public User(){
    }

    public User(long id, String firstName, String lastName, String email, String phone, String address, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role = role;
    }
}
