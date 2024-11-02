package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findUserByRole_libelleRole(String role);

    boolean existsByEmail(String mail);
}
