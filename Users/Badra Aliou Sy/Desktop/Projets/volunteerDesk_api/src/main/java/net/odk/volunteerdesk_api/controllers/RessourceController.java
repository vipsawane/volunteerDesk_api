package net.odk.volunteerdesk_api.controllers;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.services.CandidatureService;
import net.odk.volunteerdesk_api.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ressource")
public class RessourceController {
    @Autowired
   private RessourceService ressourceService;
    @Autowired
    private CandidatureService candidatureService;

    @PostMapping("/createRessource")
    @Operation(summary = "Ajouter une Ressource")
    public ResponseEntity<Ressource> createRessource(@RequestBody Ressource evenement){
        Ressource saved = ressourceService.creerRessource(evenement);
        System.out.println("Ressource controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/updateRessource/{id}")
    @Operation(summary="Modifier une ressource")
    public ResponseEntity<Ressource> updateRessource(@RequestBody Ressource ressource, @PathVariable Long id) {
        return new ResponseEntity<>(ressourceService.update(ressource, id), HttpStatus.OK);
    }

    @GetMapping("/getAllRessource")
    @Operation(summary="Lister toutes les Ressource")
    public ResponseEntity<List<Ressource>> getAllRessource(){
        return new ResponseEntity<>(ressourceService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/likeRessource/{id}")
    @Operation(summary="Liker une ressource")
    public ResponseEntity<Ressource> likeRessource(@PathVariable Long idRessource) throws Exception{
        return new ResponseEntity<>(ressourceService.updateLike(idRessource), HttpStatus.OK);
    }

    @GetMapping("/getAllRessourceById")
    @Operation(summary="Lister Ressource par id")
    public ResponseEntity<Ressource> getRessourceById(@PathVariable Long idRessource){
        return new ResponseEntity<>(ressourceService.findById(idRessource), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRessource/{id}")
    @Operation(summary = "Supprimer ressource")
    public ResponseEntity<Void> deleteRessource(@PathVariable("id") Long idResource) {
        ressourceService.deleteById(idResource);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}

