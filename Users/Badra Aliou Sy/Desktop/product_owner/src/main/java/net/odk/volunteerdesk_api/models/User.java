package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;


    private String nomUser;
    private String prenomUser;
    @Column(nullable = false)
    private String photoUser;
    @Column(nullable = false)
    private String description;
    private String motDePasse;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    private Date dateNaissance;
    @Column(nullable = false)
    private String photoProfil;




}
