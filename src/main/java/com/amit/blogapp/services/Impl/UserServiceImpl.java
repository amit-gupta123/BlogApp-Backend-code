package com.amit.blogapp.services.Impl;
import com.amit.blogapp.dtos.UserDto;
import com.amit.blogapp.entity.User;
import com.amit.blogapp.exceptions.UserAlreadyExistsException;
import com.amit.blogapp.exceptions.UserNotFound;
import com.amit.blogapp.repositories.UserRepository;
import com.amit.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    // field injection is ont recommended
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private User dtoToUser( UserDto userDto ){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    // creating user
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
//        if(userRepository.findById(userDto.getId())!=null){
//            throw new UserAlreadyExistsException("User","id",userDto.getId());
//        }
//        else {
            User savedUser =  userRepository.save(user);
       // }
        return userToDto(savedUser);
    }

    // read user
    @Override
    public UserDto getUserById(Long id) {
        User user =  userRepository.findById(id).orElseThrow(()->new UserNotFound("User","id",id));
        System.out.println(user.getId());
        return userToDto(user);
    }

    // update a user
    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
       User user =  userRepository.findById(id).orElseThrow(()->new UserNotFound("User","id",id));
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setAbout(userDto.getAbout());
       user.setUsername(userDto.getUsername());
       user.setPassword(userDto.getPassword());
       user.setId(userDto.getId());
       User updatedUser = this.userRepository.save(user);
       return userToDto(updatedUser);
    }

    // delete a user
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // get all user
    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : userList){
            UserDto userDto = new UserDto();
            userDto.setAbout(user.getAbout());
            userDto.setEmail(user.getEmail());
            userDto.setName(user.getName());
            userDto.setUsername(user.getUsername());
            userDto.setId(user.getId());
            userDto.setPassword(user.getPassword());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
