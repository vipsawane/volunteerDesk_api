package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class DetailsEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idDetailsEvenement;
    private String lieuEvenement;
    private Date dateDebutEvenement;
    private Date dateFinEvenement;
    @Column(nullable = false)
    private Boolean participation;
    @Column(nullable = false)
    private Integer nbrCandidat;
    @Column(nullable = false)
    private Integer nbrParticipant;
}
