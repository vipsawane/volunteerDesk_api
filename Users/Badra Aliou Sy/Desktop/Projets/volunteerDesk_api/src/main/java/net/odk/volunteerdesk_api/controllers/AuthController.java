package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/connexion")
    public ResponseEntity<?> connexion(@RequestParam String email, @RequestParam String password) {
        Object authenticatedEntity = authService.authenticate(email, password);

        if (authenticatedEntity != null) {
            return ResponseEntity.ok(authenticatedEntity); // Retourne l'utilisateur ou l'organisation
        } else {
            return ResponseEntity.status(401).body("Utilisateur invalide");
        }
    }
}