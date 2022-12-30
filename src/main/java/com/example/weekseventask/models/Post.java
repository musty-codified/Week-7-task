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
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @Column(name = "post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(length = 500, nullable = false)
    private String postContent;

    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER)
    private Set<PostLikes> postLikes;

    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER)
    private Set<Comment> postComments;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime lastDateModified;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
