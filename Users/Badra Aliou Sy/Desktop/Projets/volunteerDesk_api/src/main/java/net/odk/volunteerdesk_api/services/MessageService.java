package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Message;
import net.odk.volunteerdesk_api.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message , MultipartFile photo) throws Exception {
        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    message.setImageMessage("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            message.setImageMessage("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            message.setImageMessage("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        return messageRepository.save(message);
    }

    public Message update(Message me, Long id, MultipartFile photo) throws Exception {
        Message m = messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun message trouvé"));
        m.setContenuMessage(me.getContenuMessage());
        m.setStatutMessage(me.getStatutMessage());

        //image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    m.setImageMessage("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            m.setImageMessage("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            m.setImageMessage("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        return messageRepository.save(m);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message findById(Long id) {
        Message m = messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun message trouvé"));
        return  m;
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

}