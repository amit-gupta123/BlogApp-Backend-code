package com.amit.blogapp.services;

import com.amit.blogapp.dtos.UserDto;
import com.amit.blogapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto user);
    public UserDto updateUser(UserDto userDto,Long id);
    public UserDto getUserById(Long id);
    public void deleteUser(Long id);
    public  List<UserDto> getAllUser();


}
