package com.api.service;

import com.api.dto.user.UserDto;
import com.api.dto.user.ViewUserDto;
import com.api.entity.User;

public interface UserService {

    ViewUserDto addNewSecretary(UserDto userDto);
}
