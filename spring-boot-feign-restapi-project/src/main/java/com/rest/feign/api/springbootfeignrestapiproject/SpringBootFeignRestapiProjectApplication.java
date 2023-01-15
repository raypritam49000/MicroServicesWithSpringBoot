package com.rest.feign.api.springbootfeignrestapiproject;

import com.rest.feign.api.springbootfeignrestapiproject.client.PostClient;
import com.rest.feign.api.springbootfeignrestapiproject.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootFeignRestapiProjectApplication implements CommandLineRunner {

    @Autowired
    private PostClient client;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeignRestapiProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(client.getAllPostData());
        System.out.println(client.getPostData(1));
        System.out.println(client.createPost(new Post(123,2332,"Java","Java is Best")));
        System.out.println(client.updatePost(1,new Post(126,2332,"Java","Java is Best")));
        System.out.println(client.deletePostData(1));
    }
}
