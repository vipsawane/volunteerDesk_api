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
@RequestMapping("/detailsEvent")
public class DetailsEvenementController {

    @Autowired
    DetailsEvenementService detailsEvenementService;

    @PostMapping("/addDetailsEvenement")
    @Operation(summary="Ajouter  DetailsEvenement")
    public ResponseEntity<DetailsEvenement> createDetailsEvenement(@RequestBody DetailsEvenement detailsEvenement) {
        return new ResponseEntity<>(detailsEvenementService.save(detailsEvenement) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier DetailsEvenement")
    public ResponseEntity<DetailsEvenement> updateDetailsEvenement(@PathVariable Long id, @RequestBody DetailsEvenement DetailsEvenement) {
        return new ResponseEntity<>(detailsEvenementService.update(DetailsEvenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllDetailsEvenement")
    @Operation(summary="Lister tous les DetailsEvenement")
    public ResponseEntity<List<DetailsEvenement>> getAll(){
        return new ResponseEntity<>(detailsEvenementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Lister DetailsEvenement par id")
    public ResponseEntity<DetailsEvenement> getAllById(@PathVariable Long idDetailsEvenement){
        return new ResponseEntity<>(detailsEvenementService.findById(idDetailsEvenement), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un DetailsEvenement")
    public ResponseEntity<Void> deleteDetailsEvenement(@PathVariable("id") Long id) {
        detailsEvenementService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}