package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.TypeEvenement;
import net.odk.volunteerdesk_api.repositories.TypeEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEvenementService {

    @Autowired
    private TypeEvenementRepository typeEvenementRepository;

    // Méthode pour créer sauvegarder un type evemenet
    public TypeEvenement save(TypeEvenement typeEvenement) {
        return typeEvenementRepository.save(typeEvenement);
    }

    public TypeEvenement update(TypeEvenement typeEvenement, Long id) {
        TypeEvenement te = typeEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );

        te.setLibelleTypeEvenement(typeEvenement.getLibelleTypeEvenement());

        return typeEvenementRepository.save(te);
    }

    // Méthode pour afficher tous type evenement
    public List<TypeEvenement> findAll(){
        return typeEvenementRepository.findAll();
    }

    public TypeEvenement getById(Long id){
        TypeEvenement typeEvenement = typeEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun type d'evenement") );
        return typeEvenement;
    }

    // Méthode pour supprimer un type evenement
    public void deleteById(Long id) {
        typeEvenementRepository.deleteById(id);
    }

}


