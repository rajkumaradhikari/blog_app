package com.raj.blog.services.impl;

import com.raj.blog.entities.Category;
import com.raj.blog.entities.Post;
import com.raj.blog.entities.User;
import com.raj.blog.exceptions.ResourceNotFoundException;
import com.raj.blog.payloads.PostDto;
import com.raj.blog.repositories.CategoryRepo;
import com.raj.blog.repositories.PostRepo;
import com.raj.blog.repositories.UserRepo;
import com.raj.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    private UserRepo userRepo;

    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()->
            new ResourceNotFoundException("User","userId",userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","categoryId",categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("defalut.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post addedPost = this.postRepo.save(post);
        return this.modelMapper.map(addedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
