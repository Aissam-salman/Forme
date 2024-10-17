package com.forme.app.auth.controller;

import com.forme.app.auth.service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {
        passwordResetService.sendPasswordResetEmail(email);
        return ResponseEntity.ok("Un email de réinitialisation a été envoyé.");
    }
}