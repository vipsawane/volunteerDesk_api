package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    @Column(unique = true)
    private String libelle;

    private String description;

    private String nbrPoste;

    private String lieuEvenement;

    private String dateDebutEvenement;

    private String dateFinEvenement;

    private String heureDebutEvenement;

    private String heureFinEvenement;

    private String organisateur;

    private String typeEvenement;


    /*@Column(nullable = true)
    private String photo;*/



    @OneToOne
    @JsonIgnore
    private DetailsEvenement detailsEvenement;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name="idOrganisation")
    private Organisation organisation;

    @OneToMany(mappedBy = "evenement")
    @JsonIgnore
    private List<Candidature> candidatures;



}
