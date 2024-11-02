package net.odk.volunteerdesk_api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.odk.volunteerdesk_api.models.AuthentificationDTO;
import net.odk.volunteerdesk_api.models.User;

import net.odk.volunteerdesk_api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    public User creer(User user) {
        return userRepository.save(user);
    }

    public User save(User user, MultipartFile photo1, MultipartFile photo2) throws Exception {
        String passWordHasher = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWordHasher);
        //image
        if (photo1 != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo1.getInputStream(),
                            rootlocation.resolve(photo1.getOriginalFilename()));
                    user.setPhotoUser("photo/"
                            + photo1.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo1.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo1.getInputStream(),
                                    rootlocation.resolve(photo1.getOriginalFilename()));
                            user.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo1.getInputStream(), rootlocation.resolve(photo1.getOriginalFilename()));
                            user.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        //image
        if (photo2 != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo2.getInputStream(),
                            rootlocation.resolve(photo2.getOriginalFilename()));
                    user.setPhotoCarteIdentite("photo/"
                            + photo2.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo2.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo2.getInputStream(),
                                    rootlocation.resolve(photo2.getOriginalFilename()));
                            user.setPhotoCarteIdentite("photo/"
                                    + photo2.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo2.getInputStream(), rootlocation.resolve(photo2.getOriginalFilename()));
                            user.setPhotoCarteIdentite("photo/"
                                    + photo2.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        return userRepository.save(user);
    }

    public User updateUser(User user, Long id, MultipartFile photo1, MultipartFile photo2) throws Exception {
        User u = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun user trouvé"));

        u.setNomUser(user.getNomUser());
        u.setPrenomUser(user.getPrenomUser());
        u.setGenre(user.getGenre());
        u.setDescription(user.getDescription());
        u.setEmail(user.getEmail());
        u.setTelephone(user.getTelephone());
        u.setDateNaissance(user.getDateNaissance());
        u.setNumCarteIdentite(user.getNumCarteIdentite());
        u.setPhotoCarteIdentite(user.getPhotoCarteIdentite());
        u.setCompetences(user.getCompetences());
        u.setAnneeExperience(user.getAnneeExperience());
        u.setNbrSuspension(user.getNbrSuspension());
        if (user.getRole() != null) {
            u.setRole(user.getRole());
        }

        //image
        if (photo1 != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo1.getInputStream(),
                            rootlocation.resolve(photo1.getOriginalFilename()));
                    u.setPhotoUser("photo/"
                            + photo1.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo1.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo1.getInputStream(),
                                    rootlocation.resolve(photo1.getOriginalFilename()));
                            u.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo1.getInputStream(), rootlocation.resolve(photo1.getOriginalFilename()));
                            u.setPhotoUser("photo/"
                                    + photo1.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        //image
        if (photo2 != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo2.getInputStream(),
                            rootlocation.resolve(photo2.getOriginalFilename()));
                    u.setPhotoCarteIdentite("photo/"
                            + photo2.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo2.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo2.getInputStream(),
                                    rootlocation.resolve(photo2.getOriginalFilename()));
                            user.setPhotoCarteIdentite("photo/"
                                    + photo2.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo2.getInputStream(), rootlocation.resolve(photo2.getOriginalFilename()));
                            u.setPhotoCarteIdentite("photo/"
                                    + photo2.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        return userRepository.save(user);
    }


    public List<User> findUserByRole(String role) {
        return userRepository.findUserByRole_libelleRole(role);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


    public User updatePassWord(Long id, String newPassWord) throws Exception {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Hacher le nouveau mot de passe
            String hashedPassword = passwordEncoder.encode(newPassWord);
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        } else {
            throw new Exception("User non trouvé avec l'ID : " + id);
        }
    }

    /*public User connexion(String email, String password){
        User user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new EntityNotFoundException("Email ou mot de passe incorrect");
        }

           return userRepository.save(user);

    }
*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        return user;
    }

    public void deleteUserById(Long id) {
    }
}