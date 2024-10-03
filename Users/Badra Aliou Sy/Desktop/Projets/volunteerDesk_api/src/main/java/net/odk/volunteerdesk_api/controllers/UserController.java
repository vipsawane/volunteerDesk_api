package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @Operation(summary = "Ajouter utilisateur")
    public ResponseEntity<User> create(
            @Valid @RequestParam("user") String userString,
            @RequestParam(value = "photoUser", required = false) MultipartFile imageFile1,
            @RequestParam(value = "cvUser", required = false) MultipartFile imageFile)
            throws Exception {
        User user = new User();
        try {
            user = new JsonMapper().readValue(userString, User.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        User savedMarque = userService.save(user, imageFile, imageFile1);
        System.out.println("user controller :" + savedMarque);

        return new ResponseEntity<>(savedMarque, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Modifier utilisateur")
    public ResponseEntity<User> updateUser(
            @Valid @RequestParam("user") String userString,
            @PathVariable Long id,
            @RequestParam(value = "photoUser", required = false) MultipartFile imageFile1,
            @RequestParam(value = "photoProfil", required = false) MultipartFile imageFile)
            throws Exception {
        User user = new User();
        try {
            user = new JsonMapper().readValue(userString, User.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        User savedMarque = userService.update(user, id, imageFile, imageFile);
        System.out.println("user controller :" + savedMarque);

        return new ResponseEntity<>(savedMarque, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updatePassword")
    public User updateUser(@PathVariable Long id, @RequestParam String password) throws Exception {
        return userService.updatePassWord(id, password);
    }

    @GetMapping("/getAllUser")
    @Operation(summary="Lister tous les utilisateurs")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllUserByRole/{libelleRole}")
    @Operation(summary="Lister utilisateur en fonction du role")
    public ResponseEntity<List<User>> getAllByRole(String libelleRole){
        return new ResponseEntity<>(userService.findAllByRole(libelleRole), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer utilisateur")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")
    @Operation(summary = "Connexion")
    public User connexions(@RequestParam("email")  String email,
                           @RequestParam("password")  String password) {
        return userService.connexion(email, password);
    }
}