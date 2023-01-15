package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> users;

    static {
        users = List.of(
                new User(1L, "Pritam Ray", "8699535682"),
                new User(2L, "Amit Kumar", "7696889454"),
                new User(3L, "Rahul Kumar", "9041410534")
        );
    }


    @Override
    public User findById(Long userId) {
        User getUser = users.stream().filter((user) -> user.getUserId().equals(userId)).findAny().get();
        return getUser;
    }
}
