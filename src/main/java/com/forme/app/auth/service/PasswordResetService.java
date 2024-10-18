package com.forme.app.auth.service;
import com.forme.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.forme.app.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final UserRepository userRepository;
    private final EmailService emailService; 

    public void sendPasswordResetEmail(String email) {
        // Vérifiez si l'utilisateur existe
        var user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            // Générer un token de réinitialisation et envoyer l'email
            String token = generateResetToken(user.get());
            emailService.sendPasswordResetEmail(email, token);
        }
    }

    private String generateResetToken(User user) {
        // Implémentez la logique pour générer un token de réinitialisation
        return "generated-token";
    }
}