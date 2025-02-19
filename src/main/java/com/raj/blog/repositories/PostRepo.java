package com.raj.blog.repositories;

import com.raj.blog.entities.Category;
import com.raj.blog.entities.Post;
import com.raj.blog.entities.User;
import com.raj.blog.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    @Query("select p from Post p where p.postTitle like :key")
    List<Post> searchByTitle(@Param("key") String title);
}
