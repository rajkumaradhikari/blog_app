package com.raj.blog.services;

import com.raj.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all posts
    List<PostDto> getAllPosts();

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keyword);

}
