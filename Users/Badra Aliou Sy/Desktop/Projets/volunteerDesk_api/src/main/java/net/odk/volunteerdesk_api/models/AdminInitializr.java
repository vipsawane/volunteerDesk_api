package net.odk.volunteerdesk_api.models;

import net.odk.volunteerdesk_api.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdminInitializr implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializr(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!userRepository.existsByEmail("sybadraaliou@gmail.com")) {
            User admin = new User();
            admin.setNomUser("SY");
            admin.setPrenomUser("Badra Aliou");
            admin.setEmail("sybadraaliou@gmail.com");
            admin.setPassword(passwordEncoder.encode("adminpassword"));
            admin.setGenre("Homme");
            admin.setPhotoUser("default_admin_photo.png");
            admin.setDescription("Default admin user");
            admin.setTelephone("74181834");
            admin.setDateNaissance(new Date());
            admin.setNumCarteIdentite("I052180");
            admin.setPhotoCarteIdentite("default_admin_id_card.png");
            admin.setCompetences("Administration");
           /* admin.setAnneeExperience(5);
            admin.setNbrSuspension(0);*/
            admin.setIsConnected(false);
            admin.setActived(true);
            userRepository.save(admin);
        }
    }
}