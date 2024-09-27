package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Admin;
import net.odk.volunteerdesk_api.models.Like;
import net.odk.volunteerdesk_api.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> findAll(){return likeRepository.findAll();}

    public Optional<Like> findById(Long id) {
        return likeRepository.findById(id);
    }

    public Like save(Like like) {
        return likeRepository.save(like);
    }

    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }
}
