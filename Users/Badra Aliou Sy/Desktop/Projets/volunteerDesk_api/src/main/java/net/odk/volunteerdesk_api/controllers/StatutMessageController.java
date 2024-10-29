package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Sanction;
import net.odk.volunteerdesk_api.models.StatutMessage;
import net.odk.volunteerdesk_api.services.StatutMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statutMessage")
public class StatutMessageController {

    @Autowired
    private StatutMessageService statutMessageService;

    @PostMapping("/createStatutMessage")
    @Operation(summary="Ajouter StatutMessage")
    public ResponseEntity<StatutMessage> createStatutMessage(@RequestBody StatutMessage statutMessage) {
        System.out.println(statutMessage.toString());
        return new ResponseEntity<>(statutMessageService.save(statutMessage) , HttpStatus.CREATED);
    }

    @PutMapping("/updateStatutMessage/{id}")
    @Operation(summary="Modifier StatutMessage")
    public ResponseEntity<StatutMessage> updateStatutMessage(@PathVariable Long id, @RequestBody StatutMessage statutMessage) {
        return new ResponseEntity<>(statutMessageService.update(statutMessage, id), HttpStatus.OK);
    }

    @GetMapping("/getAllStatutMessage")
    @Operation(summary="Lister tous les StatutMessage")
    public ResponseEntity<List<StatutMessage>> getAllStatutMessage(){
        return new ResponseEntity<>(statutMessageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllStatutMessageById")
    @Operation(summary=" Lister statut message par id")
    public ResponseEntity<StatutMessage> getStatutMessageById(@PathVariable Long idStatutMessage){
        return new ResponseEntity<>(statutMessageService.findAllById(idStatutMessage), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStatutMessage/{id}")
    @Operation(summary = "Supprimer StatutMessage")
    public ResponseEntity<Void> deleteStatutMessage(@PathVariable("id") Long id) {
        statutMessageService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
