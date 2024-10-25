package com.forme.app.auth.controller;

import com.forme.app.auth.dto.EmailRequest;
import com.forme.app.auth.dto.PasswordResetRequest;
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
    public ResponseEntity<String> forgotPassword(@RequestBody EmailRequest emailRequest) {
    if (emailRequest.getEmail() == null || emailRequest.getEmail().isEmpty()) {
        return ResponseEntity.badRequest().body("L'email est obligatoire.");
    }
    passwordResetService.sendPasswordResetEmail(emailRequest.getEmail());
    return ResponseEntity.ok("Un email de réinitialisation a été envoyé.");
}
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest passwordResetRequest) {
        boolean isReset = passwordResetService.resetPassword(passwordResetRequest.getToken(), passwordResetRequest.getPassword());
        if (isReset) {
            return ResponseEntity.ok("Mot de passe réinitialisé avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Token invalide ou expiré.");
        }
    }
}