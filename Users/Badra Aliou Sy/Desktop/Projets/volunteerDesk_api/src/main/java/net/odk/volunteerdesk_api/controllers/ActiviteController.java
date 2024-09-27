package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.models.Activite;
import net.odk.volunteerdesk_api.services.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activite") // URL de base pour les activités
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    // Récupérer toutes les activités
    @GetMapping
    public List<Activite> getAllActivites() {
        return activiteService.findAll();
    }

    // Récupérer une activité par ID
    @GetMapping("/{id}")
    public ResponseEntity<Activite> getActiviteById(@PathVariable Long id) {
        Optional<Activite> activite = activiteService.findById(id);
        if (activite.isPresent()) {
            return ResponseEntity.ok(activite.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer une nouvelle activité
    @PostMapping
    public ResponseEntity<Activite> createActivite(@RequestBody Activite activite) {
        Activite savedActivite = activiteService.save(activite);
        return ResponseEntity.ok(savedActivite);
    }

    /*// Mettre à jour une activité existante
    @PutMapping("/{id}")
    public ResponseEntity<Activite> updateActivite(@PathVariable Long id, @RequestBody Activite activiteDetails) {
        Optional<Activite> activite = activiteService.findById(id);

        if (activite.isPresent()) {
            Activite activiteToUpdate = activite.get();
            activiteToUpdate.setNom(activiteDetails.getNom()); // Exemple de champ à mettre à jour
            activiteToUpdate.setDescription(activiteDetails.getDescription()); // Autre exemple
            // Met à jour d'autres champs ici...

            Activite updatedActivite = activiteService.save(activiteToUpdate);
            return ResponseEntity.ok(updatedActivite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    // Supprimer une activité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Long id) {
        Optional<Activite> activite = activiteService.findById(id);

        if (activite.isPresent()) {
            activiteService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
