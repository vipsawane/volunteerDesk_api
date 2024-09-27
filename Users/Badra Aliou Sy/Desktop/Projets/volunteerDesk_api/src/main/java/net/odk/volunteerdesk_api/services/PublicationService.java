package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Publication;
import net.odk.volunteerdesk_api.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public List<Publication> findAll(){return publicationRepository.findAll();}

    public Optional<Publication> findById(Long id) {
        return publicationRepository.findById(id);
    }

    public Publication save(Publication publication) {
        return publicationRepository.save(publication);
    }

    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }
}
