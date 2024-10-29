package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Sanction;
import net.odk.volunteerdesk_api.services.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanction")
public class SanctionController {
    @Autowired
    private SanctionService sanctionService;

    @PostMapping("/createSanction")
    @Operation(summary="Créer Sanction")
    public ResponseEntity<Sanction> createSanction(@RequestBody Sanction sanction) {
        System.out.println(sanction.toString());
        return new ResponseEntity<>(sanctionService.save(sanction) , HttpStatus.CREATED);
    }

    @PutMapping("/updateSanction/{id}")
    @Operation(summary="Modifier sanction")
    public ResponseEntity<Sanction> updateSanction(@PathVariable Long id, @RequestBody Sanction sanction) {
        return new ResponseEntity<>(sanctionService.update(sanction, id), HttpStatus.OK);
    }

    @GetMapping("/getAllSanction")
    @Operation(summary="Lister toutes les Sanctions")
    public ResponseEntity<List<Sanction>> getAllSanction(){
        return new ResponseEntity<>(sanctionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllSanctionById")
    @Operation(summary=" Lister Sanction par id")
    public ResponseEntity<Sanction> getSanctionById(@PathVariable Long idSanction){
        return new ResponseEntity<>(sanctionService.findById(idSanction), HttpStatus.OK);
    }

    @DeleteMapping("/deleteSanction/{id}")
    public ResponseEntity<Void> deleteSanction(@PathVariable("id") Long id) {
        sanctionService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
