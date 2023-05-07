package com.example.service;

import com.example.dto.user.UserDto;
import com.example.dto.user.ViewUserDto;
import com.example.entity.User;

public interface UserService {

    ViewUserDto addNewSecretary(UserDto userDto);
}
