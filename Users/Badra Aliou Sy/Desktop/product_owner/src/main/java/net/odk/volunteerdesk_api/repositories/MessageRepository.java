package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
