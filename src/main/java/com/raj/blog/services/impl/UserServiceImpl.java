package com.raj.blog.services.impl;

import com.raj.blog.entities.User;
import com.raj.blog.exceptions.ResourceNotFoundException;
import com.raj.blog.payloads.UserDto;
import com.raj.blog.repositories.UserRepo;
import com.raj.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        UserDto savedUserDto = userToDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User"," id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);
        UserDto updatedUserDto = this.userToDto(updatedUser);
        return updatedUserDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User ","UserId",userId));
        UserDto getUserById = userToDto(user);
        return getUserById;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> listOfUsers = users.stream().map(user ->
                this.userToDto(user)).filter(Objects::nonNull).collect(Collectors.toList());
        return listOfUsers;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","userId",userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto){
//        User user = new User();
//
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
//        return user;
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }
    private UserDto userToDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
//        return userDto;
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
