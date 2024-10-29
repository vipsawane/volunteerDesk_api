package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/evenement")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping("/createEvenement")
    @Operation(summary = "Ajouter evenement")
    public ResponseEntity<Evenement> createEvenement(@RequestBody Evenement evenement) throws Exception {
        Evenement saved = evenementService.save(evenement);
        System.out.println("Ressource controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Modifier evenement")
    public ResponseEntity<Evenement> updateEvenement( @RequestBody Evenement evenement, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(evenementService.update(evenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllEvenement")
    @Operation(summary = "Lister de tous les Evenements")
    public ResponseEntity<List<Evenement>> getAllEvenement() {
        return new ResponseEntity<>(evenementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getEvenementById/{id}") // Mappage corrigé
    @Operation(summary = "Lister Evenement par id")
    public ResponseEntity<Evenement> getEvenementById(@PathVariable Long idEvenement) {
        return new ResponseEntity<>(evenementService.findById(idEvenement), HttpStatus.OK);
    }

   /* @GetMapping("/getEvenementByType/{typeEvenement}") // Mappage corrigé
    @Operation(summary = "Lister Evenement par type")
    public ResponseEntity<Evenement> getEvenementByType(@PathVariable String typeEvenement) {
        return new ResponseEntity<>(evenementService.findByType(typeEvenement), HttpStatus.OK);
    }*/

    @DeleteMapping("/deleteEvenement/{id}")
    @Operation(summary = "Supprimer un Evenement")
    public ResponseEntity<Void> deleteEvenement(@PathVariable("id") Long id) {
        evenementService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
