package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Mentorat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoratRepository extends JpaRepository<Mentorat, Long> {
}
