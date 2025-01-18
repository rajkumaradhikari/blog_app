package com.raj.blog.repositories;

import com.raj.blog.entities.Category;
import com.raj.blog.entities.Post;
import com.raj.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
