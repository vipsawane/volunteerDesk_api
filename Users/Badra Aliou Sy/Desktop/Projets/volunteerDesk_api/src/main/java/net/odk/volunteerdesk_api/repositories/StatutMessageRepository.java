package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.StatutMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutMessageRepository extends JpaRepository<StatutMessage,Long> {
}
