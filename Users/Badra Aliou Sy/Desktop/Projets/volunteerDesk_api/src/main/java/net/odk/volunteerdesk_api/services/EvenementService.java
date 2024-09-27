package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Activite;
import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.repositories.ActiviteRepository;
import net.odk.volunteerdesk_api.repositories.EvenementRepository;
import net.odk.volunteerdesk_api.repositories.MentoratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    private ActiviteRepository activiteRepository;

    private MentoratRepository mentoratRepository;

    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    public Optional<Evenement> findById(Long id) {
        return evenementRepository.findById(id);
    }

    /*// Mettre à jour un evenement existant
    @PutMapping("/{id}")
    public EvenementRepository<Evenement> updateEvenement(@PathVariable Long id, @RequestBody Evenement evenementDetails) {
        Optional<Evenement> evenement = evenementRepository.findById(id);

        if (evenement.isPresent()) {
            Evenement evenementToUpdate = evenement.get();
            evenementToUpdate.setLibelle(evenementDetails.getLibelle());
            evenementToUpdate.setDescription(evenementDetails.getDescription());
            evenementToUpdate.setLieuEvenement(evenementDetails.getLieuEvenement());
            evenementToUpdate.setPhoto(evenementDetails.getPhoto());
            evenementToUpdate.setNbrPoste(evenementDetails.getNbrPoste());
            // Met à jour d'autres champs ici...

            Evenement updatedEvenment = evenementRepository.save(evenementToUpdate);
            return EvenementRepository.ok(updatedEvenment);
        } else {
            return EvenementRepository.notFound().build();
        }
*/
    public Evenement save(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

}
