package com.raj.blog.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "post_title", length = 100, nullable = false)
    private String postTitle;

    @Column(name ="post_content", length = 1000, nullable = false)
    private String postContent;

    @Column(name = "post_image")
    private String imageName;

    private Date addedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
