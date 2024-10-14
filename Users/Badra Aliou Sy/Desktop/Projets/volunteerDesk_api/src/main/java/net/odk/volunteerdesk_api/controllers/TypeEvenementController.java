package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.TypeEvenement;
import net.odk.volunteerdesk_api.services.TypeEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeEvenement")
public class TypeEvenementController {

    @Autowired
    private TypeEvenementService typeEvenementService;

    @PostMapping("/addTypeEvenement")
    @Operation(summary="Ajouter un type Evenement")
    public ResponseEntity<TypeEvenement> createTypeEvenement(@RequestBody TypeEvenement typeEvenement) {
        System.out.println(typeEvenement.toString());
        return new ResponseEntity<>(typeEvenementService.save(typeEvenement) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier un type evenment")
    public ResponseEntity<TypeEvenement> updateTypeEvenement(@PathVariable Long id, @RequestBody TypeEvenement typeEvenement) {
        return new ResponseEntity<>(typeEvenementService.update(typeEvenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllRole")
    @Operation(summary="Lister tous les type Evenements")
    public ResponseEntity<List<TypeEvenement>> getAll(){
        return new ResponseEntity<>(typeEvenementService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un type d'evenement")
    public ResponseEntity<Void> deleteTypeEvenement(@PathVariable("id") Long id) {
        typeEvenementService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}

