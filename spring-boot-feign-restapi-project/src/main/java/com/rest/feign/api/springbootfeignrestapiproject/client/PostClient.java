package com.rest.feign.api.springbootfeignrestapiproject.client;

import com.rest.feign.api.springbootfeignrestapiproject.models.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-client", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostClient {

    @GetMapping
    public List<Post> getAllPostData();

    @GetMapping("{id}")
    public Post getPostData(@PathVariable("id") int id);

    @PostMapping
    public Post createPost(@RequestBody Post post);

    @PutMapping("{id}")
    public Post updatePost(@PathVariable("id") int id,@RequestBody Post post);

    @DeleteMapping("{id}")
    public Object deletePostData(@PathVariable("id") int id);
}
