package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Candidature;
import net.odk.volunteerdesk_api.repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    public Candidature save(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public Candidature update(Candidature cd, Long id){
        Candidature candidature = candidatureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun candidature trouvé") );

        candidature.setLibelleCandidature(candidature.getLibelleCandidature());
        candidature.setEtatCandidature(candidature.getEtatCandidature());
        candidature.setDateCandidature(candidature.getDateCandidature());

        return candidatureRepository.save(candidature);
    }


    public List<Candidature> findAll(){
        return candidatureRepository.findAll();
    }

    public Candidature findById(Long id) {
        Candidature candidature = candidatureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune candidature trouvée") );
        return candidature;
    }

    public void deleteById(Long id) {
        candidatureRepository.deleteById(id);
    }
}
