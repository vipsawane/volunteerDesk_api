package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
