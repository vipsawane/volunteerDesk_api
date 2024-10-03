package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole_libelleRole(String role);

    User findByEmail(String email);
}
