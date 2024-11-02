package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement save(Evenement evenement) throws Exception {
        return evenementRepository.save(evenement);
    }


        /*//image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    evenement.setPhoto("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            evenement.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            evenement.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }*/
               /* }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }*/


    public Evenement update(Evenement evenement, Long id ) throws Exception{
        Evenement ev = evenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun evenement trouvé"));
        ev.setLibelle(evenement.getLibelle());
        ev.setDescription(evenement.getDescription());
        ev.setDateDebutEvenement(evenement.getDateDebutEvenement());
        ev.setDateFinEvenement(evenement.getDateFinEvenement());
        ev.setHeureDebutEvenement(evenement.getHeureDebutEvenement());
        ev.setHeureFinEvenement(evenement.getHeureFinEvenement());
        ev.setOrganisateur(evenement.getOrganisateur());
        ev.setTypeEvenement(evenement.getTypeEvenement());
        ev.setLieuEvenement(evenement.getLieuEvenement());
        ev.setNbrPoste(evenement.getNbrPoste());
        ev.setTypeEvenement(evenement.getTypeEvenement());

        /*//image
        if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                    ev.setPhoto("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                            ev.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            ev.setPhoto("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception ex) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception x) {
                throw new Exception(x.getMessage());
            }
        }
*/
        return evenementRepository.save(ev);
    }

    public List<Evenement> findAll() {

        return evenementRepository.findAll();
    }

    public Evenement findById(Long id) {
        Evenement e  = evenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun evenement trouvé"));
        return e;
    }



    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }





   /* public String findByType(String typeEvenement) {
        return typeEvenement;
    }*/
}