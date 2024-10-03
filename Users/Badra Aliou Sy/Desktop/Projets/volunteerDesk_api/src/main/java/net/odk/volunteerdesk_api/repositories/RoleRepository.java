package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
