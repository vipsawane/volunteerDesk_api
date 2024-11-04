package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.ResponseAuth;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseAuth authenticate(String email, String password) {
        // Cherche l'utilisateur
        User user = userRepository.findByEmail(email);

        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            // Retourne l'utilisateur authentifié avec son rôle
            return new ResponseAuth(true, user, user.getRole());

        }

        // Si l'utilisateur n'est pas trouvé, retourne un échec
        return new ResponseAuth(false, null, "Données incorrectes, veuillez réessayer");
    }


    }
