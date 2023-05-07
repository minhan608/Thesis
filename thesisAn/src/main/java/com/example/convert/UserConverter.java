package com.example.convert;

import com.example.dto.user.UserDto;
import com.example.dto.user.ViewUserDto;
import com.example.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserConverter {

    public ViewUserDto mapUserToViewUserDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, ViewUserDto.class);
    }
}
