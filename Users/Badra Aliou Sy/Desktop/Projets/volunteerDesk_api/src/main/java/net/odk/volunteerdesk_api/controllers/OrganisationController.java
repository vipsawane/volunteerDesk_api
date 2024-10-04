package net.odk.volunteerdesk_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.models.User;
import net.odk.volunteerdesk_api.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @PostMapping("/addOrganisation")
    @Operation(summary = "Ajouter organisation")
    public ResponseEntity<Organisation> create(
            @Valid @RequestParam("organisation") String organisationString,
            @RequestParam(value = "logo", required = false) MultipartFile logo)
            throws Exception {
        Organisation organisation = new Organisation();
        try {
            organisation = new JsonMapper().readValue(organisationString, Organisation.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Organisation savedOrganisation = organisationService.save(organisation, logo);
        System.out.println("organisation controller :" + savedOrganisation);

        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Modifier organisation")
    public ResponseEntity<Organisation> updateOrganisation(
            @Valid @RequestParam("organisation") String organisationString,
            @PathVariable Long id,
            @RequestParam(value = "logo", required = false) MultipartFile logo)
            throws Exception {
        Organisation organisation = new Organisation();
        try {
            organisation = new JsonMapper().readValue(organisationString, Organisation.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Organisation savedOrganisation = organisationService.update(organisation, id, logo);
        System.out.println("user controller :" + savedOrganisation);

        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updatePassword")
    public Organisation updateOrganisation(@PathVariable Long id, @RequestParam String password) throws Exception {
        return organisationService.updatePassWord(id, password);
    }
    @GetMapping("/getAllOrganisation")
    @Operation(summary="Lister toutes les Organisations")
    public ResponseEntity<List<Organisation>> getAll(){
        return new ResponseEntity<>(organisationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganisationById/{id}")
    @Operation(summary="Lister organisation par id")
    public ResponseEntity<Optional<Organisation>> getAllById(@PathVariable Long idOrganisation){
        return new ResponseEntity<>(organisationService.findById(idOrganisation), HttpStatus.OK);
    }

    public ResponseEntity<Organisation> getOrganisationById(@PathVariable Long idOrganisation) {
        Optional<Organisation> organisation = organisationService.findById(idOrganisation);
        return organisation
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer organisation")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        organisationService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}