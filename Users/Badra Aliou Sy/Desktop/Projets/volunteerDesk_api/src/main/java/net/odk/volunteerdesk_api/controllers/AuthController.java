package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/connexion")
    public ResponseEntity<?> connexion(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        Object authenticatedEntity = authService.authenticate(email, password);

        if (authenticatedEntity != null) {
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok().headers(headers).body(authenticatedEntity);
        } else {
            return ResponseEntity.status(401).body("Utilisateur invalide");
        }
    }
}