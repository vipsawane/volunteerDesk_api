package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.EtatCandidature;
import net.odk.volunteerdesk_api.models.StatutMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatCandidatureRepository extends JpaRepository<EtatCandidature, Long> {
}
