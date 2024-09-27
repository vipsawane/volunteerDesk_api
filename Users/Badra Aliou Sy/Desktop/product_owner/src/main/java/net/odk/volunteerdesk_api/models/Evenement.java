package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    @Column(unique = true)
    private String libelle;
    private String description;
    private String lieuEvenement;
    @Column(nullable = false)
    private String organisateur;
    @Column(nullable = false)
    private String photo;
    private Integer nbrPoste;
}
