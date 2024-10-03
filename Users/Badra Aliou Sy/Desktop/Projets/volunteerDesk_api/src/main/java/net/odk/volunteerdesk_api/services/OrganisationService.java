package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;


    public Organisation update(Organisation org, Long id){
        Organisation organisation =  organisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune organisation trouvé"));

        organisation.setNumeroIdentification(organisation.getNumeroIdentification());
        organisation.setRaisonSocial(organisation.getRaisonSocial());
        organisation.setDescription(organisation.getDescription());
        organisation.setSiege(organisation.getSiege());
        organisation.setDomaineActivite(organisation.getDomaineActivite());
        organisation.setDateCreation(organisation.getDateCreation());
        organisation.setNbrSanction(organisation.getNbrSanction());

        return organisationRepository.save(organisation);
    }

    public List<Organisation> findAll(){
        return organisationRepository.findAll();
    }

    public Organisation findById(Long id) {
        Organisation organisation =  organisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune organisation trouvée"));
        return organisation;
    }

    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public void deleteById(Long id) {
        organisationRepository.deleteById(id);
    }
}