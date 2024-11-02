package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.odk.volunteerdesk_api.models.AuthentificationDTO;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/createUser")
    @Operation(summary = "Ajouter utilisateur")
    public ResponseEntity<User> createUser(
            @Valid @RequestParam("user") String userString,
            @RequestParam(value = "photoUser", required = false) MultipartFile imageFile1,
            @RequestParam(value = "photoCarteIdentite", required = false) MultipartFile imageFile)
            throws Exception {
        User user = new User();
        try {
            user = new JsonMapper().readValue(userString, User.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        User savedUser = userService.save(user, imageFile1, imageFile);
        System.out.println("user controller :" + savedUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("creer")
    @PutMapping("/updateUser/{id}")
    @Operation(summary = "Modifier utilisateur")
    public ResponseEntity<User> updateUser(
            @Valid @RequestParam("user") String userString,
            @PathVariable Long id,
            @RequestParam(value = "photoUser", required = false) MultipartFile imageFile1,
            @RequestParam(value = "photoCarteIdentite", required = false) MultipartFile imageFile)
            throws Exception {
        User user = new User();
        try {
            user = new JsonMapper().readValue(userString, User.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        User savedUser = userService.updateUser(user, id, imageFile1, imageFile);
        System.out.println("user controller :" + savedUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updatePassword")
    public User updateUser(@PathVariable Long id, @RequestParam String password) throws Exception {
        return userService.updatePassWord(id, password);
    }

    @GetMapping("/getAllUser")
    @Operation(summary="Lister tous les utilisateurs")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/getUserByRole/{libelleRole}")
    @Operation(summary="Lister utilisateur en fonction du role")
    public ResponseEntity<List<User>> getUserByRole(String libelleRole){
        return new ResponseEntity<>(userService.findUserByRole(libelleRole), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    @Operation(summary="Lister user par id")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long idUser){
        return new ResponseEntity<>(userService.findUserById(idUser), HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer utilisateur")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

   /* @PostMapping("/connexion")
    @Operation(summary = "Connexion")
    public User connexion(@RequestParam("email")  String email,
                           @RequestParam("password")  String password) {
        return userService.connexion(email, password);
    }*/

    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authentificationDTO.email(), authentificationDTO.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return ResponseEntity.ok("Connexion réussie !");
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'authentification");
        }
    }


}