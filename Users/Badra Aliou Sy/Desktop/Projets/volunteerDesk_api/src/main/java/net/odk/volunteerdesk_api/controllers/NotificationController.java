package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Notification;
import net.odk.volunteerdesk_api.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/createNotification")
    @Operation(summary="Ajouter une Notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        System.out.println(notification.toString());
        return new ResponseEntity<>(notificationService.save(notification) , HttpStatus.CREATED);
    }

    @PutMapping("/updateNotification/{id}")
    @Operation(summary="Modifier une notification")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return new ResponseEntity<>(notificationService.update(notification, id), HttpStatus.OK);
    }

    @GetMapping("/getAllNotification")
    @Operation(summary="Lister de toutes les Notification")
    public ResponseEntity<List<Notification>> getAllNotification(){
        return new ResponseEntity<>(notificationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllNotificationById")
    @Operation(summary="Lister Notification par id")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long idNotification){
        return new ResponseEntity<>(notificationService.findById(idNotification), HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotification/{id}")
    @Operation(summary = "Supprimer une notification")
    public ResponseEntity<Void> deleteNotification(@PathVariable("id") Long id) {
        notificationService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}