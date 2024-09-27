package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Notification;
import net.odk.volunteerdesk_api.models.Sanction;
import net.odk.volunteerdesk_api.repositories.NotificationRepository;
import net.odk.volunteerdesk_api.repositories.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    public List<Sanction> findAll(){return sanctionRepository.findAll();}

    public Optional<Sanction> findById(Long id) {
        return sanctionRepository.findById(id);
    }

    public Sanction save(Sanction sanction) {
        return sanctionRepository.save(sanction);
    }

    public void deleteById(Long id) {
        sanctionRepository.deleteById(id);
    }
}
