package com.blogapp.services;

import com.blogapp.entities.User;
import com.blogapp.exceptions.ResoureceNotFoundExcepeiton;
import com.blogapp.payload.UserDto;
import com.blogapp.repostiories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{
   @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.maptoEntity(userDto);
        User savedUser = userRepositories.save(user);
        return maptoDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepositories.findById(userId).orElseThrow(
                () -> new ResoureceNotFoundExcepeiton("User", "id", userId)

        );
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setAbout(user.getAbout());
        User updatedUser = userRepositories.save(user);
        return  maptoDto(updatedUser);

    }

    @Override
    public UserDto getUserById(Integer UserId) {
        User user = userRepositories.findById(UserId).orElseThrow(
                () -> new ResoureceNotFoundExcepeiton("User", "id", UserId));

        return maptoDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepositories.findAll();
        List<UserDto> userDtos = users.stream().map(user -> maptoDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepositories.findById(userId).orElseThrow(
                () -> new ResoureceNotFoundExcepeiton("User", "id", userId)
        );

        userRepositories.delete(user);
    }

    private User maptoEntity(UserDto userDto){
         User user = new User();
         user.setId(userDto.getId());
         user.setName(userDto.getName());
         user.setEmail(userDto.getEmail());
         user.setPassword(userDto.getPassword());
         user.setAbout(userDto.getAbout());
         return user;
    }
  private UserDto maptoDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());

        return userDto;
    }


}
