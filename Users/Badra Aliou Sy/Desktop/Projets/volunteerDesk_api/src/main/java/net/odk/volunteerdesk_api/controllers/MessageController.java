package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Message;
import net.odk.volunteerdesk_api.services.EvenementService;
import net.odk.volunteerdesk_api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @PostMapping("/addMessage")
    @Operation(summary = "Ajouter un  Message")
    public ResponseEntity<Message> create(
            @Valid @RequestParam("message") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Message ev = new Message();
        try {
            ev = new JsonMapper().readValue(eventString, Message.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Message saved = messageService.save(ev, imageFile);
        System.out.println("message controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier un message")
    public ResponseEntity<Message> updateEvent(
            @Valid @RequestParam("Message") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
        Message ev = new Message();
        try {
            ev = new JsonMapper().readValue(eventString, Message.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Message saved = messageService.update(ev, id, imageFile);
        System.out.println("message controller :" + saved);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllMessage")
    @Operation(summary="Lister  tous les Messages")
    public ResponseEntity<List<Message>> getAll(){
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Lister message par id")
    public ResponseEntity<Message> getAllById(@PathVariable Long idMessage){
        return new ResponseEntity<>(messageService.findById(idMessage), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un message")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
