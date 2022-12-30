package com.example.weekseventask.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(length = 20)
    private String sex;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(length = 50)
    private String dob;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Post> posts;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime lastDateModified;

}
