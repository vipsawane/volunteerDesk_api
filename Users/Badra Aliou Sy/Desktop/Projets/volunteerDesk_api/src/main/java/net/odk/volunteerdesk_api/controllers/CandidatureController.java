package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Candidature;
import net.odk.volunteerdesk_api.services.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/candidature")
public class CandidatureController {

    @Autowired
    private CandidatureService candidatureService;

    @PostMapping("/addCandidature")
    @Operation(summary="Ajouter une candidature")
    public ResponseEntity<Candidature> createCandidature(@RequestBody Candidature candidature) {
        System.out.println(candidature.toString());
        return new ResponseEntity<>(candidatureService.save(candidature) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier une candidature")
    public ResponseEntity<Candidature> updateCandidature(@PathVariable Long id, @RequestBody Candidature candidature) {
        return new ResponseEntity<>(candidatureService.update(candidature, id), HttpStatus.OK);
    }

    @GetMapping("/getAllCandidature")
    @Operation(summary="Lister toutes les candidature")
    public ResponseEntity<List<Candidature>> getAll(){
        return new ResponseEntity<>(candidatureService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    @Operation(summary="Lister candidature par id")
    public ResponseEntity<Candidature> getAllById(@PathVariable Long idCandidature){
        return new ResponseEntity<>(candidatureService.findById(idCandidature), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer une candidature")
    public ResponseEntity<Void> deleteCandidature(@PathVariable("id") Long id) {
        candidatureService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}