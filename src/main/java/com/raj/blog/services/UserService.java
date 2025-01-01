package com.raj.blog.services;

import com.raj.blog.payloads.UserDto;

import java.util.List;

public interface UserService {
   UserDto createUser(UserDto userDto);
   UserDto updateUser(UserDto userDto, Integer userId);
   UserDto getUserById(Integer userId);
   List<UserDto> getAllUser();
   void deleteUser(Integer userId);


}
