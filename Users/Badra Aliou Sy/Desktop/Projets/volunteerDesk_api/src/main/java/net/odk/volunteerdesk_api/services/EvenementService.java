package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement save(Evenement evenement, MultipartFile photo) throws Exception {

        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    evenement.setPhoto("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            evenement.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            evenement.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        return evenementRepository.save(evenement);
    }

    public Evenement update(Evenement e, Long id , MultipartFile photo ) throws Exception{
        Evenement ev = evenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun evenement trouvé"));
        ev.setLibelle(e.getLibelle());
        ev.setDescription(e.getDescription());
        e.setNbrPoste(e.getNbrPoste());



        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    ev.setPhoto("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            ev.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            ev.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception ex) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception x) {
                throw new Exception(x.getMessage());
            }
        }

        return evenementRepository.save(ev);
    }

    public List<Evenement> findAll() {

        return evenementRepository.findAll();
    }

    public Evenement findById(Long id) {
        Evenement e  = evenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun evenement trouvé"));
        return e;
    }

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

}