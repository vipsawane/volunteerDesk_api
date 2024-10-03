package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.odk.volunteerdesk_api.models.Role;
import net.odk.volunteerdesk_api.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    @Operation(summary="Ajouter un role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        System.out.println(role.toString());
        return new ResponseEntity<>(roleService.save(role) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier un role")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.update(role, id), HttpStatus.OK);
    }

    @GetMapping("/getAllRole")
    @Operation(summary="Lister tous les rôles")
    public ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer role")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}