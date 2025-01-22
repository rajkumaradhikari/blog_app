package com.raj.blog.payloads;


import com.raj.blog.entities.Category;
import com.raj.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    private String postTitle;
    private String postContent;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;




}
