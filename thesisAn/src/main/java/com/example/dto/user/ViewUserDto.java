package com.example.dto.user;

import com.example.dto.role.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewUserDto {
    private Long id;
    private String username;
    private String name;
    private String email;
    private RoleDto role;
}
