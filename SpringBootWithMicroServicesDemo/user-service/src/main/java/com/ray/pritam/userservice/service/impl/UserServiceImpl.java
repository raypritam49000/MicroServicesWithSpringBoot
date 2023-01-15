package com.ray.pritam.userservice.service.impl;

import com.ray.pritam.userservice.entity.User;
import com.ray.pritam.userservice.model.UserDto;
import com.ray.pritam.userservice.repository.UserRepository;
import com.ray.pritam.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto findByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        User savedUser = this.userRepository.save(user);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtoList = users.stream().map((user) -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto findById(Long userId) {
        User user = this.userRepository.findById(userId).get();
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = this.userRepository.findById(userId).get();
        User updatedUser = null;
        if (user != null && !user.getUsername().equals("") && !user.getEmail().equals("") && !user.getPassword().equals("")) {
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            updatedUser = this.userRepository.save(user);
        }
        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        Boolean isDeleted = false;
        User user = this.userRepository.findById(userId).get();
        if(user!=null) {
            this.userRepository.delete(user);
            isDeleted = true;
        }
        return isDeleted;
    }
}
