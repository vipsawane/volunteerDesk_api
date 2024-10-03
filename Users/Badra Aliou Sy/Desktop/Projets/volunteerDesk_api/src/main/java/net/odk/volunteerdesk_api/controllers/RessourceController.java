package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.services.CandidatureService;
import net.odk.volunteerdesk_api.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/ressource")
public class RessourceController {
    @Autowired
   private RessourceService ressourceService;
    @Autowired
    private CandidatureService candidatureService;

    @PostMapping("/addRessource")
    @Operation(summary = "Ajouter une Ressource")
    public ResponseEntity<Ressource> create(
            @Valid @RequestParam("ressource") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Ressource ev = new Ressource();
        try {
            ev = new JsonMapper().readValue(eventString, Ressource.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Ressource saved = ressourceService.creerRessource(ev, imageFile);
        System.out.println("Ressource controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier une ressource")
    public ResponseEntity<Ressource> updateEvent(
            @Valid @RequestParam("ressource") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Ressource ev = new Ressource();
        try {
            ev = new JsonMapper().readValue(eventString, Ressource.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Ressource saved = ressourceService.update(ev, id, imageFile);
        System.out.println("Ressource controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllRessource")
    @Operation(summary="Lister toutes les Ressource")
    public ResponseEntity<List<Ressource>> getAll(){
        return new ResponseEntity<>(ressourceService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/like/{id}")
    @Operation(summary="Liker une ressource")
    public ResponseEntity<Ressource> likeRessource(@PathVariable Long idRessource) throws Exception{
        return new ResponseEntity<>(ressourceService.updateLike(idRessource), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Lister Ressource par id")
    public ResponseEntity<Ressource> getAllById(@PathVariable Long idRessource){
        return new ResponseEntity<>(ressourceService.findById(idRessource), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer ressource")
    public ResponseEntity<Void> deleteRessource(@PathVariable("id") Long id) {
        candidatureService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}

