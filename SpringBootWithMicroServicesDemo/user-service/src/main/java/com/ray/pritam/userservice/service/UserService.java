package com.ray.pritam.userservice.service;

import com.ray.pritam.userservice.model.UserDto;

import java.util.List;

public interface UserService {
    public UserDto findByUsername(String username);
    public UserDto createUser(UserDto userDto);
    public List<UserDto> findAllUsers();
    public UserDto findById(Long userId);
    public UserDto updateUser(Long userId, UserDto userDto);
    public Boolean deleteUser(Long userId);
}
