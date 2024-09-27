package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Activite;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.ActiviteRepository;
import net.odk.volunteerdesk_api.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    // Méthode pour afficher toutes les activités
    public List<Activite> findAll(){return activiteRepository.findAll();}

    // Méthode pour afficher les activites par id
    public Optional<Activite> findById(Long id) {
        return activiteRepository.findById(id);
    }

    // Méthode pour sauvegarder une activité
    public Activite save(Activite activite) {
        return activiteRepository.save(activite);
    }

   /* // Mettre à jour une activité existante
    @PutMapping("/{id}")
    public ActiviteRepository<Activite> updateActivite(@PathVariable Long id, @RequestBody Activite activiteDetails) {
        Optional<Activite> activite = activiteRepository.findById(id);

        if (activite.isPresent()) {
            Activite activiteToUpdate = activite.get();
            activiteToUpdate.setLibelle(activiteDetails.getLibelle());
            activiteToUpdate.setDescription(activiteDetails);
            activiteToUpdate.setDescription(activiteDetails.getDescription()); // Autre exemple
            // Met à jour d'autres champs ici...

            Activite updatedActivite = activiteRepository.save(activiteToUpdate);
            return ActiviteRepository.ok(updatedActivite);
        } else {
            return ActiviteRepository.notFound().build();
        }
*/
    // Méthode pour supprimer une activité
    public void deleteById(Long id) {
        activiteRepository.deleteById(id);
    }
}
