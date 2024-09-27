package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Notification;
import net.odk.volunteerdesk_api.models.Ressouce;
import net.odk.volunteerdesk_api.models.Senior;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.repositories.NotificationRepository;
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
    public Ressouce creerRessource(Ressouce ressource) {
        return ressourceRepository.save(ressource);
    }

    // Méthode pour afficher toutes les ressources
    public List<Ressouce> findAll(){return ressourceRepository.findAll();}

    // Méthode pour afficher les ressources par id
    public Optional<Ressouce> findById(Long id) {
        return ressourceRepository.findById(id);
    }

    // Méthode pour sauvegarder une ressource
    public Ressouce save(Ressouce ressouce) {
        return ressourceRepository.save(ressouce);
    }

    // Méthode pour supprimer une ressource
    public void deleteById(Long id) {
        ressourceRepository.deleteById(id);
    }
}
