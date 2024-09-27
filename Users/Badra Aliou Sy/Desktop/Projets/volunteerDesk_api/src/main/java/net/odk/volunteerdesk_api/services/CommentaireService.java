package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Commentaire;
import net.odk.volunteerdesk_api.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository recrutementRepository;

    public List<Commentaire> findAll(){ return recrutementRepository.findAll();}

    public Optional<Commentaire> findById(Long id) {
        return recrutementRepository.findById(id);
    }

    public Commentaire save(Commentaire recrutement) {
        return recrutementRepository.save(recrutement);
    }

    public void deleteById(Long id) {
        recrutementRepository.deleteById(id);
    }
}
