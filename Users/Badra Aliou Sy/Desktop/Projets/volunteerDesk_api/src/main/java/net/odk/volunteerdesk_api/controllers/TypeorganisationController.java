package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.TypeEvenement;
import net.odk.volunteerdesk_api.models.TypeOrganisation;
import net.odk.volunteerdesk_api.services.TypeEvenementService;
import net.odk.volunteerdesk_api.services.TypeOrganisationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeOrganisation")
public class TypeorganisationController {

    @Autowired
    private TypeOrganisationservice typeOrganisationservice;

    @PostMapping("/addTypeOrganisation")
    @Operation(summary="Ajouter un type Organisation")
    public ResponseEntity<TypeOrganisation> createTypeOrganisation(@RequestBody TypeOrganisation typeOrganisation) {
        System.out.println(typeOrganisation.toString());
        return new ResponseEntity<>(typeOrganisationservice.save(typeOrganisation) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier un type organisation")
    public ResponseEntity<TypeOrganisation> updateTypeOrganisation(@PathVariable Long id, @RequestBody TypeOrganisation typeOrganisation) {
        return new ResponseEntity<>(typeOrganisationservice.update(typeOrganisation, id), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganisation")
    @Operation(summary="Lister tous les type organisation")
    public ResponseEntity<List<TypeOrganisation>> getAll(){
        return new ResponseEntity<>(typeOrganisationservice.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un type organisation")
    public ResponseEntity<Void> deleteTypeOrgnanisation(@PathVariable("id") Long id) {
        typeOrganisationservice.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}

