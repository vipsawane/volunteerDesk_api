package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Admin;
import net.odk.volunteerdesk_api.models.Role;
import net.odk.volunteerdesk_api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Méthode pour afficher tous les admins
    public List<Role> findAll(){return roleRepository.findAll();}

    // Méthode pour créer un nouveau admin
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    // Méthode pour créer sauvegarder un admin
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    // Méthode pour supprimer un admin
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
    }



