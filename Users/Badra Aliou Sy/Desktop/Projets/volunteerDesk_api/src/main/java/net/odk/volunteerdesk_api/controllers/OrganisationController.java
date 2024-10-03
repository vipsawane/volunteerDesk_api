package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @PostMapping("/addOrganisation")
    @Operation(summary="Ajouter une Organisation")
    public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) {
        System.out.println(organisation.toString());
        return new ResponseEntity<>(organisationService.save(organisation) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier une organisation")
    public ResponseEntity<Organisation> updateOrganisation(@PathVariable Long id, @RequestBody Organisation organisation) {
        return new ResponseEntity<>(organisationService.update(organisation, id), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganisation")
    @Operation(summary="Lister toutes les Organisations")
    public ResponseEntity<List<Organisation>> getAll(){
        return new ResponseEntity<>(organisationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Lister Organisation par id")
    public ResponseEntity<Organisation> getAllById(@PathVariable Long idOrganisation){
        return new ResponseEntity<>(organisationService.findById(idOrganisation), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable("id") Long id) {
        organisationService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}