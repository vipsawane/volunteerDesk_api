package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.models.TypeOrganisation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Organisation findByemailOrganisation(String emailOrganisation);

}
