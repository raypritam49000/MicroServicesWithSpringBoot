package com.rest.feign.api.springbootfeignrestapiproject.controllers;

import com.rest.feign.api.springbootfeignrestapiproject.client.PostClient;
import com.rest.feign.api.springbootfeignrestapiproject.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostClient postClient;

    @PostMapping
    public ResponseEntity<Map> createPost(@RequestBody Post post){
        try {
            if(post!=null && post.getUserId()>0 && post.getTitle()!=null && !post.getTitle().equals("") && post.getBody()!=null && !post.getBody().equals("")){
               Post createPost = postClient.createPost(post);
               return new ResponseEntity<Map>(Map.of("message","Post Created","statusCode",201,"statusMessage","CREATED","isSuccess",true,"data",createPost), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Map>(Map.of("message","All Parameter are required","statusCode",400,"statusMessage","BAD_REQUEST","isSuccess",false), HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Map> getAllPost(){
        try {
            List<Post> posts = postClient.getAllPostData();
            if(posts!=null && posts.size()>0){
                return new ResponseEntity<Map>(Map.of("message","Post List","statusCode",200,"statusMessage","SUCCESS","isSuccess",true,"data",posts), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<Map>(Map.of("message","Post Not Found","statusCode",404,"statusMessage","NOT_FOUND","isSuccess",false), HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Map> getPost(@PathVariable("id") int id){
        try {
            Post post = postClient.getPostData(id);
            if(post!=null){
                return new ResponseEntity<Map>(Map.of("message","Post List","statusCode",200,"statusMessage","SUCCESS","isSuccess",true,"data",post), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<Map>(Map.of("message","Post Not Found","statusCode",404,"statusMessage","NOT_FOUND","isSuccess",false), HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Map> updatePost(@PathVariable("id") int id,@RequestBody Post post){
        try {
            if(post!=null && post.getUserId()>0 && post.getTitle()!=null && !post.getTitle().equals("") && post.getBody()!=null && !post.getBody().equals("")){
                Post updatePost = postClient.updatePost(id, post);
                return new ResponseEntity<Map>(Map.of("message","Post Update","statusCode",201,"statusMessage","UPDATED","isSuccess",true,"data",updatePost), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Map>(Map.of("message","All Parameter are required","statusCode",400,"statusMessage","BAD_REQUEST","isSuccess",false), HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map> deletePost(@PathVariable("id") int id){
        try {
               postClient.deletePostData(id);
                return new ResponseEntity<Map>(Map.of("message","Post Deleted","statusCode",200,"statusMessage","SUCCESS","isSuccess",true), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createPost")
    public ResponseEntity<Map> savedPost(Post post){
        try {
            if(post!=null && post.getUserId()>0 && post.getTitle()!=null && !post.getTitle().equals("") && post.getBody()!=null && !post.getBody().equals("")){
                Post createPost = postClient.createPost(post);
                return new ResponseEntity<Map>(Map.of("message","Post Created","statusCode",201,"statusMessage","CREATED","isSuccess",true,"data",createPost), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Map>(Map.of("message","All Parameter are required","statusCode",400,"statusMessage","BAD_REQUEST","isSuccess",false), HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            return new ResponseEntity<Map>(Map.of("message","Server Error","statusCode",501,"statusMessage","INTERNAL_SERVER_ERROR","isSuccess",false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
