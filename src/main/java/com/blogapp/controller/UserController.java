package com.blogapp.controller;

import com.blogapp.payload.UserDto;
import com.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private   UserService userService;


    @PostMapping("/")
    public ResponseEntity<UserDto>createUser( @RequestBody UserDto userDto){
        UserDto createUserDto = userService.createUser(userDto);
         return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){


        UserDto updatedUser = userService.updateUser(userDto, userId);

        return  new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);

    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>  getSingleUser(@PathVariable Integer userId){
        UserDto userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById,HttpStatus.OK);

    }



}
