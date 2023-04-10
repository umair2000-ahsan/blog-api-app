package com.blogapp.services;

import com.blogapp.entities.User;
import com.blogapp.payload.UserDto;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto  getUserById(Integer UserId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);
}
