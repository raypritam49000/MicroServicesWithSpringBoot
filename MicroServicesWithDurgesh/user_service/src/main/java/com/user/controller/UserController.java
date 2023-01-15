package com.user.controller;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = this.userService.findById(userId);
        //http://localhost:8888/contact/user/1
        //List<Contact> contacts = this.restTemplate.getForObject("http://localhost:8888/contact/user/" + userId, List.class);
        List<Contact> contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);
        user.setContacts(contacts);

        return user;
    }
}
