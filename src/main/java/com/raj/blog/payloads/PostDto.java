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

    private String postTitle;
    private String postContent;
    private String imageName;
    private Date addedDate;
    private Category category;
    private User user;




}
