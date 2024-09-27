package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public List<Organisation> findAll(){return organisationRepository.findAll();}

    public Optional<Organisation> findById(Long id) {
        return organisationRepository.findById(id);
    }

    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public void deleteById(Long id) {
        organisationRepository.deleteById(id);
    }
}
