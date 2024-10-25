package com.forme.app.auth.dto;

import lombok.Data;

@Data
public class PasswordResetRequest {
    private String token;
    private String password;
}