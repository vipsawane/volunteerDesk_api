package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.StatutMessage;
import net.odk.volunteerdesk_api.repositories.StatutMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutMessageService {

    @Autowired
    private StatutMessageRepository statutMessageRepository;

    public StatutMessage save(StatutMessage statutMessage) {
        return statutMessageRepository.save(statutMessage);
    }

    public StatutMessage update(StatutMessage statutMessage, Long id){
        StatutMessage re = statutMessageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune donnée trouvé"));
        re.setLibelleStatutMessage(statutMessage.getLibelleStatutMessage());
        return statutMessageRepository.save(re);
    }
    public List<StatutMessage> findAll(){
        return statutMessageRepository.findAll();
    }

    public void deleteById(Long id) {
        statutMessageRepository.deleteById(id);
    }
}