package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Role;
import net.odk.volunteerdesk_api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Méthode pour créer sauvegarder un role
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role, Long id) {
        Role r = roleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );

        r.setLibelleRole(role.getLibelleRole());

        return roleRepository.save(r);
    }

    // Méthode pour afficher tous les roles
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role getById(Long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun role trouvé") );
        return role;
    }

    // Méthode pour supprimer un role
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

}


