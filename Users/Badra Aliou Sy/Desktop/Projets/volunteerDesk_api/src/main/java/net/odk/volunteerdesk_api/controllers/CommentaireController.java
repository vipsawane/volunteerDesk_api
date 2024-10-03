package net.odk.volunteerdesk_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.Commentaire;
import net.odk.volunteerdesk_api.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping("/addCommentaire")
    @Operation(summary="Ajouter un commentaire")
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        System.out.println(commentaire.toString());
        return new ResponseEntity<>(commentaireService.save(commentaire) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modifier un commentaire")
    public ResponseEntity<Commentaire> updateRole(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        return new ResponseEntity<>(commentaireService.update(commentaire, id), HttpStatus.OK);
    }

    @GetMapping("/getAllRole")
    @Operation(summary="Lister tous les Commentaire")
    public ResponseEntity<List<Commentaire>> getAll(){
        return new ResponseEntity<>(commentaireService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer commentaire")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable("id") Long id) {
        commentaireService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
