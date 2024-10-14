package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.TypeEvenement;
import net.odk.volunteerdesk_api.models.TypeOrganisation;
import net.odk.volunteerdesk_api.repositories.TypeEvenementRepository;
import net.odk.volunteerdesk_api.repositories.TypeOrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOrganisationservice {

    @Autowired
    private TypeOrganisationRepository typeOrganisationRepository;

    // Méthode pour créer sauvegarder un type d'organisation
    public TypeOrganisation save(TypeOrganisation typeOrganisation) {
        return typeOrganisationRepository.save(typeOrganisation);
    }

    public TypeOrganisation update(TypeOrganisation typeOrganisation, Long id) {
        TypeOrganisation to = typeOrganisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );

        to.setLibelleTypeOrganisation(typeOrganisation.getLibelleTypeOrganisation());

        return typeOrganisationRepository.save(to);
    }

    // Méthode pour afficher tous type organisation
    public List<TypeOrganisation> findAll(){
        return typeOrganisationRepository.findAll();
    }

    public TypeOrganisation getById(Long id){
        TypeOrganisation typeOrganisation = typeOrganisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun type d'organisation") );
        return typeOrganisation;
    }

    // Méthode pour supprimer un type organisation
    public void deleteById(Long id) {
        typeOrganisationRepository.deleteById(id);
    }

}



