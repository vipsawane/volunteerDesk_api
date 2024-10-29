package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    // Méthode pour créer une nouvelle ressource
    public Ressource creerRessource(Ressource ressource  ) {

        return ressourceRepository.save(ressource);
    }

    public Ressource update(Ressource r ,Long idRessource ) {
        Ressource re = ressourceRepository.findById(idRessource).orElseThrow(() -> new IllegalStateException("Aucune ressource trouvée"));
        re.setLibelleRessource(r.getLibelleRessource());
        re.setContenuRessource(r.getContenuRessource());
        return ressourceRepository.save(re);
    }

    // Méthode pour afficher toutes les ressources
    public List<Ressource> findAll(){
        return ressourceRepository.findAll();
    }

    // Méthode pour afficher les ressources par id
    public Ressource findById(Long idRessource) {
        Ressource ressource = ressourceRepository.findById(idRessource).orElseThrow(() -> new IllegalStateException("Aucune ressource trouvée"));
        return ressource;
    }

    public Ressource updateLike(Long idRessource) throws Exception {
        Optional<Ressource> re = ressourceRepository.findById(idRessource);

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
    public void deleteById(Long idRessource) {
        ressourceRepository.deleteById(idRessource);
    }
}