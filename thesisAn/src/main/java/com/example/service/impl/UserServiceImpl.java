//package com.example.service.impl;
//
//import com.example.convert.UserConverter;
//import com.example.dto.role.RoleDto;
//import com.example.dto.user.UserDto;
//import com.example.dto.user.ViewUserDto;
//import com.example.entity.Role;
//import com.example.entity.User;
//import com.example.repository.RoleRepository;
//import com.example.repository.UserRepository;
//import com.example.service.UserService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@AllArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final RoleRepository roleRepository;
//
//    private final UserRepository userRepository;
//
//    @Override
//    public ViewUserDto addNewSecretary(UserDto userDto) {
//        RoleDto roleDto = new RoleDto();
//        roleDto.setName("Secretary");
//
//        Role role = roleRepository.findByName(roleDto.getName());
//        if (role == null) {
//            log.error("Error when create with Role");
//            return null;
//        }
//        ViewUserDto viewUserDto = new ViewUserDto();
//        User user = new UserConverter().mapUserToViewUserDto(user, viewUserDto);
//        user.setRole(role);
//        user = userRepository.save(user);
//    }
//    }
//}
