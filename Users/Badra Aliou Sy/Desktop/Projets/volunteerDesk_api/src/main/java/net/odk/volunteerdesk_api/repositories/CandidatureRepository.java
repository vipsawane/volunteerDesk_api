package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}
