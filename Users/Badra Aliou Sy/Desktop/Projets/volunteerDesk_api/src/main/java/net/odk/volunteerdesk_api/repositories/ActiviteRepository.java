package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
}
