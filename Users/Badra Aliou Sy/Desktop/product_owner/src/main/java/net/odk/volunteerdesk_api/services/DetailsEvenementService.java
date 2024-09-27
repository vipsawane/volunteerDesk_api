package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Candidature;
import net.odk.volunteerdesk_api.models.DetailsEvenement;
import net.odk.volunteerdesk_api.repositories.CandidatureRepository;
import net.odk.volunteerdesk_api.repositories.DetailsEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsEvenementService {

    @Autowired
    private DetailsEvenementRepository detailsEvenementRepository;

    public List<DetailsEvenement> findAll(){return detailsEvenementRepository.findAll();}

    public Optional<DetailsEvenement> findById(Long id) {
        return detailsEvenementRepository.findById(id);
    }

    public DetailsEvenement save(DetailsEvenement detailsEvenement) {
        return detailsEvenementRepository.save(detailsEvenement);
    }

    public void deleteById(Long id) {
        detailsEvenementRepository.deleteById(id);
    }
}
