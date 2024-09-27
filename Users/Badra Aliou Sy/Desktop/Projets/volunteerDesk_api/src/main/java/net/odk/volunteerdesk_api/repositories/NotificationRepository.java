package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
