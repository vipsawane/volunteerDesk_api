package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
