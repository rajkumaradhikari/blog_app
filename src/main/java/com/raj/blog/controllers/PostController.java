package com.raj.blog.controllers;




import com.raj.blog.config.AppConstants;
import com.raj.blog.payloads.ApiResponse;
import com.raj.blog.payloads.PostDto;
import com.raj.blog.payloads.PostResponse;
import com.raj.blog.services.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDto addedPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(addedPost, HttpStatus.CREATED);
    }

    //get post by category
    @GetMapping("/postByCategory/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> postByCategory = postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postByCategory,HttpStatus.OK);
    }
    //get post by user
    @GetMapping("/postByUser/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> postByUser = postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
    }

    //get post by post id
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }

    @GetMapping("/allPosts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir
    ){
        PostResponse allPosts = postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(allPosts,HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse("post deleted successfully",true),HttpStatus.OK);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }

    @GetMapping("/post/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(
            @PathVariable("keyword") String keyword
    ){
        List<PostDto> postDtos = this.postService.searchPosts(keyword);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }
}
