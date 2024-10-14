package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/evenement")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping("/addEvenement")
    @Operation(summary = "Ajouter evenement")
    public ResponseEntity<Evenement> createEvenement(
            @Valid @RequestParam("evenement") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Evenement ev = new Evenement();
        try {
            ev = new JsonMapper().readValue(eventString, Evenement.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Evenement saved = evenementService.save(ev, imageFile);
        System.out.println("evenement controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier evenement")
    public ResponseEntity<Evenement> updateEvenement(
            @Valid @RequestParam("evenement") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Evenement ev = new Evenement();
        try {
            ev = new JsonMapper().readValue(eventString, Evenement.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Evenement saved = evenementService.update(ev, id, imageFile);
        System.out.println("evenement controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEvenement")
    @Operation(summary="Lister de tous  les Evenements")
    public ResponseEntity<List<Evenement>> getAll(){
        return new ResponseEntity<>(evenementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Lister  Evenement par id")
    public ResponseEntity<Evenement> getAllById(@PathVariable Long idEvenement){
        return new ResponseEntity<>(evenementService.findById(idEvenement), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un Evenement")
    public ResponseEntity<Void> deleteEvenement(@PathVariable("id") Long id) {
        evenementService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}