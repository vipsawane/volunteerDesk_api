package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    // Méthode pour créer une nouvelle ressource
    public Ressource creerRessource(Ressource ressource, MultipartFile photo) throws Exception {

        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    ressource.setImageRessource("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            ressource.setImageRessource("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            ressource.setImageRessource("photo/"
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

        return ressourceRepository.save(ressource);
    }

    public Ressource update(Ressource r ,Long id , MultipartFile photo ) throws Exception{
        Ressource re = ressourceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune publication trouvé"));
        re.setLibelleRessource(r.getLibelleRessource());
        re.setContenuRessource(r.getContenuRessource());
        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    re.setImageRessource("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            re.setImageRessource("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            re.setImageRessource("photo/"
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
        return ressourceRepository.save(re);
    }

    // Méthode pour afficher toutes les ressources
    public List<Ressource> findAll(){
        return ressourceRepository.findAll();
    }

    // Méthode pour afficher les ressources par id
    public Ressource findById(Long id) {
        Ressource re = ressourceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune publication trouvé"));
        return re;
    }

    public Ressource updateLike(Long id) throws Exception {
        Optional<Ressource> re = ressourceRepository.findById(id);

        if (re.isPresent()) {
            Ressource r = re.get();
            int count = r.getLikeRessource() + 1;
            r.setLikeRessource(count);

            return ressourceRepository.save(r);
        } else {
            throw new Exception("Une erreur s'est produite");
        }
    }

    // Méthode pour supprimer une ressource
    public void deleteById(Long id) {
        ressourceRepository.deleteById(id);
    }
}