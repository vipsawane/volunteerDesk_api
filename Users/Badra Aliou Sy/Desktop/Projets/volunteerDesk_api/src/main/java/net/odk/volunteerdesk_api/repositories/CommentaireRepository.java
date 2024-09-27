package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
