package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
