package com.ray.pritam.userservice.controller;

import com.ray.pritam.userservice.model.UserDto;
import com.ray.pritam.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        try {
             List<UserDto> userDtoList = this.userService.findAllUsers();
             if(userDtoList!=null && userDtoList.size()>0){
                 return ResponseEntity.ok(Map.of("message","User List","isSuccess",true,"statusCode",200,"data",userDtoList));
             }
             else{
                 return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404,"data",userDtoList));
             }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId){
        try {
            UserDto userDto = this.userService.findById(userId);
            if(userDto!=null && !userDto.getUsername().equals("")){
                return ResponseEntity.ok(Map.of("message","User List","isSuccess",true,"statusCode",200,"data",userDto));
            }
            else{
                return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404,"data",userDto));
            }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }


    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        try {
            UserDto savedUser = this.userService.createUser(userDto);
            if(savedUser!=null && !userDto.getUsername().equals("")){
                return ResponseEntity.ok(Map.of("message","User Created","isSuccess",true,"statusCode",200,"data",savedUser));
            }
            else{
                return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404,"data",savedUser));
            }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        try {
            Boolean isDeleted = this.userService.deleteUser(userId);
            if(isDeleted){
                return ResponseEntity.ok(Map.of("message","User Deleted","isSuccess",true,"statusCode",203));
            }
            else{
                return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404));
            }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username){
        try {
            UserDto userDto = this.userService.findByUsername(username);
            if(userDto!=null && !userDto.getUsername().equals("")){
                return ResponseEntity.ok(Map.of("message","User List","isSuccess",true,"statusCode",200,"data",userDto));
            }
            else{
                return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404,"data",userDto));
            }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId,@RequestBody UserDto userDto){
        try {
            UserDto updateUser = this.userService.updateUser(userId,userDto);
            if( updateUser!=null && ! updateUser.getUsername().equals("")){
                return ResponseEntity.ok(Map.of("message","User Updated","isSuccess",true,"statusCode",200,"data",updateUser));
            }
            else{
                return ResponseEntity.ok(Map.of("message","User Data Not Found","isSuccess",false,"statusCode",404,"data",updateUser));
            }
        }
        catch (Exception exception){
            return ResponseEntity.ok(Map.of("message",exception.getMessage(),"isSuccess",false,"statusCode",501));
        }

    }

}
