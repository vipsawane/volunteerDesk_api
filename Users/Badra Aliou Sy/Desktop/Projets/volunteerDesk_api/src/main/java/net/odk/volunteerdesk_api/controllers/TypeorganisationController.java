package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.TypeOrganisation;
import net.odk.volunteerdesk_api.services.TypeOrganisationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeOrganisation")
public class TypeOrganisationController {

    @Autowired
    private TypeOrganisationservice typeOrganisationservice;

    @PostMapping("/createTypeOrganisation")
    @Operation(summary="Ajouter un type Organisation")
    public ResponseEntity<TypeOrganisation> createTypeOrganisation(@RequestBody TypeOrganisation typeOrganisation) {
        System.out.println(typeOrganisation.toString());
        return new ResponseEntity<>(typeOrganisationservice.save(typeOrganisation) , HttpStatus.CREATED);
    }

    @PutMapping("/updateTypeOrganisation/{id}")
    @Operation(summary="Modifier un type organisation")
    public ResponseEntity<TypeOrganisation> updateTypeOrganisation(@PathVariable Long id, @RequestBody TypeOrganisation typeOrganisation) {
        return new ResponseEntity<>(typeOrganisationservice.update(typeOrganisation, id), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganisation")
    @Operation(summary="Lister tous les type organisation")
    public ResponseEntity<List<TypeOrganisation>> getAllOrganisation(){
        return new ResponseEntity<>(typeOrganisationservice.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getTypeOrganisationById")
    @Operation(summary=" Lister les type d'organisation par id")
    public ResponseEntity<TypeOrganisation> getTypeOrganisationById(@PathVariable Long idTypeOrganisation){
        return new ResponseEntity<>(typeOrganisationservice.findById(idTypeOrganisation), HttpStatus.OK);
    }


    @DeleteMapping("/deleteTypeOrgnanisation/{id}")
    @Operation(summary = "Supprimer un type organisation")
    public ResponseEntity<Void> deleteTypeOrgnanisation(@PathVariable("id") Long id) {
        typeOrganisationservice.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}

