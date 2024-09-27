package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
