package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Publication;
import net.odk.volunteerdesk_api.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @PostMapping("/createPublication")
    @Operation(summary = "Ajouter Publication")
    public ResponseEntity<Publication> createPublication(
            @Valid @RequestParam("publication") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Publication ev = new Publication();
        try {
            ev = new JsonMapper().readValue(eventString, Publication.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Publication saved = publicationService.save(ev, imageFile);
        System.out.println("Publication controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/updatePublication/{id}")
    @Operation(summary="Modifier publication")
    public ResponseEntity<Publication> updatePublication(
            @Valid @RequestParam("publication") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Publication ev = new Publication();
        try {
            ev = new JsonMapper().readValue(eventString, Publication.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Publication saved = publicationService.update(ev,id, imageFile);
        System.out.println("Publication controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllPublication")
    @Operation(summary="Lister toutes les Publications")
    public ResponseEntity<List<Publication>> getAllPublication(){
        return new ResponseEntity<>(publicationService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/likePublication/{id}")
    @Operation(summary="Liker une Publication")
    public ResponseEntity<Publication> likePublication(@PathVariable Long idPublication) throws Exception{
        return new ResponseEntity<>(publicationService.updateLike(idPublication), HttpStatus.OK);
    }

    @GetMapping("/getPublicationById")
    @Operation(summary="Lister Publication par id")
    public ResponseEntity<Publication> getPublicationById(@PathVariable Long idPublication){
        return new ResponseEntity<>(publicationService.findById(idPublication), HttpStatus.OK);
    }

    @DeleteMapping("/deletePublication/{id}")
    @Operation(summary = "Supprimer publication")
    public ResponseEntity<Void> deletePublication(@PathVariable("id") Long id) {
        publicationService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}