package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.ResponseAuth;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.UserRepository;
import net.odk.volunteerdesk_api.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final OrganisationRepository organisationRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository,
                       OrganisationRepository organisationRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.organisationRepository = organisationRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseAuth authenticate(String email, String password) {
        // Cherche d'abord dans les utilisateurs
        User user = userRepository.findByEmail(email);

        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return new ResponseAuth(true, user, user.getRole()); // L'utilisateur est authentifié
        }

        // Cherche ensuite dans les organisations
        Organisation organisation = organisationRepository.findByEmail(email);
        if (organisation != null && bCryptPasswordEncoder.matches(password, organisation.getPassword())) {
            return new ResponseAuth(true, organisation, "ORGANISATION"); // L'organisation est authentifiée
        }

        // Si ni l'utilisateur ni l'organisation ne sont trouvés, retourne un échec
        return new ResponseAuth(false, null, "Données incorrectes, veuillez réessayer");
    }
}