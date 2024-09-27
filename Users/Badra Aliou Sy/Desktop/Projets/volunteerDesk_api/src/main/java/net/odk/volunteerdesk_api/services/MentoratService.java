package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Admin;
import net.odk.volunteerdesk_api.models.Mentorat;
import net.odk.volunteerdesk_api.repositories.MentoratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentoratService {


    @Autowired
    private MentoratRepository mentoratRepository;

    public List<Mentorat> findAll(){return mentoratRepository.findAll();}

    public Optional<Mentorat> findById(Long id) {
        return mentoratRepository.findById(id);
    }

    public Mentorat save(Mentorat mentorat) {
        return mentoratRepository.save(mentorat);
    }

    public void deleteById(Long id) {
        mentoratRepository.deleteById(id);
    }


}
