package net.odk.volunteerdesk_api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Organisation save(Organisation organisation  , MultipartFile logo) throws Exception {
        String passWordHasher = passwordEncoder.encode(organisation.getMotDePasse());
        organisation.setMotDePasse(passWordHasher);
        //image
        if (logo != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(logo.getInputStream(),
                            rootlocation.resolve(logo.getOriginalFilename()));
                    organisation.setLogo("photo/"
                            + logo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + logo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(logo.getInputStream(),
                                    rootlocation.resolve(logo.getOriginalFilename()));
                            organisation.setLogo("photo/"
                                    + logo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(logo.getInputStream(), rootlocation.resolve(logo.getOriginalFilename()));
                            organisation.setLogo("photo/"
                                    + logo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }


        return organisationRepository.save(organisation);
    }

    public Organisation update(Organisation organisation  ,Long id, MultipartFile logo) throws Exception {
        Organisation org = organisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun user trouvé"));

        org.setDescription(organisation.getDescription());
        org.setDomaineActivite(organisation.getDomaineActivite());
        org.setDateCreation(organisation.getDateCreation());
        org.setDescription(organisation.getDescription());
        org.setNumeroIdentification(organisation.getNumeroIdentification());
        org.setDomaineActivite(organisation.getDomaineActivite());
        org.setMotDePasse(org.getMotDePasse());
        org.setSanction(organisation.getSanction());
        org.setLogo(organisation.getLogo());
        org.setRaisonSocial(organisation.getRaisonSocial());
        org.setSiege(organisation.getSiege());
        org.setEmailOrganisation(organisation.getEmailOrganisation());
        org.setAdresse(organisation.getAdresse());


        //image
        if (logo != null) {
            String location = "C:\\laragon\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(logo.getInputStream(),
                            rootlocation.resolve(logo.getOriginalFilename()));
                    org.setLogo("photo/"
                            + logo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + logo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(logo.getInputStream(),
                                    rootlocation.resolve(logo.getOriginalFilename()));
                            org.setLogo("photo/"
                                    + logo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(logo.getInputStream(), rootlocation.resolve(logo.getOriginalFilename()));
                            org.setLogo("photo/"
                                    + logo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }


        return organisationRepository.save(organisation);
    }

    public List<Organisation> findAll(){
        return organisationRepository.findAll();
    }

    public Optional<Organisation> findById(Long id) {
        return organisationRepository.findById(id);
    }

    public Organisation updatePassWord(Long id, String newPassWord) throws Exception {
        Optional<Organisation> userOpt = organisationRepository.findById(id);

        if (userOpt.isPresent()) {
            Organisation organisation = userOpt.get();

            // Hacher le nouveau mot de passe
            String hashedPassword = passwordEncoder.encode(newPassWord);
            organisation.setMotDePasse(hashedPassword);
            return organisationRepository.save(organisation);
        } else {
            throw new Exception("User non trouvé avec l'ID : " + id);
        }
    }

    public Organisation connexion(String emailOrganisation, String password){
        Organisation organisation = organisationRepository.findByemailOrganisation(emailOrganisation);
        if (organisation == null || !passwordEncoder.matches(password, organisation.getMotDePasse())) {
            throw new EntityNotFoundException("Email ou mot de passe incorrect");
        }
        return organisation;
    }

    public void deleteById(Long id) {
        organisationRepository.deleteById(id);
    }

}