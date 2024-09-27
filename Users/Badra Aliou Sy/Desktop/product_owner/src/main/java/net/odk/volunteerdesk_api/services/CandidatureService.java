package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Candidature;
import net.odk.volunteerdesk_api.repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    public List<Candidature> findAll(){return candidatureRepository.findAll();}

    public Optional<Candidature> findById(Long id) {
        return candidatureRepository.findById(id);
    }

    public Candidature save(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public void deleteById(Long id) {
        candidatureRepository.deleteById(id);
    }
}
