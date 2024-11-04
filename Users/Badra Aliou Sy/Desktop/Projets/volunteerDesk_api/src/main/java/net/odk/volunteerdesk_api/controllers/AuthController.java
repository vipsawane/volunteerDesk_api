package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.models.ResponseAuth;
import net.odk.volunteerdesk_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/connexion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> connexion(@PathVariable Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        System.out.print(payload.get("email"));
        ResponseAuth authenticatedEntity = authService.authenticate(email, password);

        if (authenticatedEntity.isAuthenticated()) {
            return ResponseEntity.ok().body(authenticatedEntity);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticatedEntity.getErrorMessage());
        }
    }
}