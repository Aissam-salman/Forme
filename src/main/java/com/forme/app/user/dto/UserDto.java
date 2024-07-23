package com.forme.app.user.dto;

import com.forme.app.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type User dto.
 */
@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
