package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Sanction;
import net.odk.volunteerdesk_api.repositories.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    public Sanction save(Sanction sanction) {
        return sanctionRepository.save(sanction);
    }

    public Sanction update(Sanction s, Long id ){
        Sanction sanction =  sanctionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sanction trouvé"));
        sanction.setLibelleSanction(s.getLibelleSanction());
        sanction.setMotifSanction(s.getMotifSanction());
        return sanctionRepository.save(sanction);
    }

    public List<Sanction> findAll(){return sanctionRepository.findAll();}

    public Sanction findById(Long id) {
        Sanction sanction =  sanctionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sanction trouvé"));
        return sanction;
    }



    public void deleteById(Long id) {
        sanctionRepository.deleteById(id);
    }
}