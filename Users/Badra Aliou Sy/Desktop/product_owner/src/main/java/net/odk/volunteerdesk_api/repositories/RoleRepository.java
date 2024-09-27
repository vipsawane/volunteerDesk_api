package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Admin, Long> {
}
