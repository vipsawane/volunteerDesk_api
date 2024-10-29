package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.DetailsEvenement;
import net.odk.volunteerdesk_api.services.DetailsEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailsEvenement")
public class DetailsEvenementController {

    @Autowired
    DetailsEvenementService detailsEvenementService;

    @PostMapping("/createDetailsEvenement")
    @Operation(summary="Ajouter  DetailsEvenement")
    public ResponseEntity<DetailsEvenement> createDetailsEvenement(@RequestBody DetailsEvenement detailsEvenement) {
        return new ResponseEntity<>(detailsEvenementService.save(detailsEvenement) , HttpStatus.CREATED);
    }

    @PutMapping("/updateDetailsEvenement/{id}")
    @Operation(summary="Modifier DetailsEvenement")
    public ResponseEntity<DetailsEvenement> updateDetailsEvenement(@PathVariable Long id, @RequestBody DetailsEvenement DetailsEvenement) {
        return new ResponseEntity<>(detailsEvenementService.update(DetailsEvenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllDetailsEvenement")
    @Operation(summary="Lister tous les DetailsEvenement")
    public ResponseEntity<List<DetailsEvenement>> getAllDetailsEvenement(){
        return new ResponseEntity<>(detailsEvenementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllDetailsEvenementById")
    @Operation(summary="Lister DetailsEvenement par id")
    public ResponseEntity<DetailsEvenement> getDetailsEvenementById(@PathVariable Long idDetailsEvenement){
        return new ResponseEntity<>(detailsEvenementService.findById(idDetailsEvenement), HttpStatus.OK);
    }

    @DeleteMapping("/deleteDetailsEvenement/{id}")
    @Operation(summary = "Supprimer un DetailsEvenement")
    public ResponseEntity<Void> deleteDetailsEvenement(@PathVariable("id") Long id) {
        detailsEvenementService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}