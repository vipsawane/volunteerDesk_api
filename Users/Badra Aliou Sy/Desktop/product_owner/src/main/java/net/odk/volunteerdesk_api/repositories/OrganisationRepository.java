package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
}
