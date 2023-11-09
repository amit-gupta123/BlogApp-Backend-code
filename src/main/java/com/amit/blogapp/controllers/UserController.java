package com.amit.blogapp.controllers;

import com.amit.blogapp.dtos.UserDto;
import com.amit.blogapp.entity.User;
import com.amit.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    // we can make it final field
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDto getUserById( @PathVariable  Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto,userDto.getId());
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> creatUser(@RequestBody UserDto userDto){
        UserDto cretedUserDto =  userService.createUser(userDto);
        return new ResponseEntity<>(cretedUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
