package com.amit.blogapp.controllers;

import com.amit.blogapp.dtos.ApiResponse;
import com.amit.blogapp.dtos.UserDto;
import com.amit.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    // we can make it final field
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById( @PathVariable  Long id){
        return new ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<List<UserDto>>( userService.getAllUser(),HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long userId){
        UserDto updatedUser = userService.updateUser(userDto,userId);
        return ResponseEntity.ok(userService.updateUser(updatedUser,userDto.getId()));
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<UserDto> creatUser(@RequestBody UserDto userDto){
        UserDto cretedUserDto =  userService.createUser(userDto);
        return new ResponseEntity<UserDto>(cretedUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true,id),HttpStatus.OK);
    }
}
