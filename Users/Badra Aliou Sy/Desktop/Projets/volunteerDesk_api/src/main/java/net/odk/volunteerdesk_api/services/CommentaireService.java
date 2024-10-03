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
    private CommentaireRepository commentaireRepository;

    public List<Commentaire> findAll(){ return commentaireRepository.findAll();}

    public Optional<Commentaire> findById(Long id) {
        return commentaireRepository.findById(id);
    }

    public Commentaire update(Commentaire c, Long id){
        Commentaire commentaire = commentaireRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun commentaire trouvé") );

        commentaire.setContenuCommentaire(commentaire.getContenuCommentaire());
        commentaire.setDateCommentaire(commentaire.getDateCommentaire());

        return commentaireRepository.save(commentaire);
    }

    public Commentaire save(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public void deleteById(Long id) {
        commentaireRepository.deleteById(id);
    }

    }

