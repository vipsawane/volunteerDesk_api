package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailsEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailsEvenement;

    private String lieuEvenement;

    private String dateDebutEvenement;

    private String dateFinEvenement;

    private Boolean participation;

    @Column(nullable = false)
    private int nbrCandidat;

    private String organisateur;

    @Column(nullable = false)
    private String Formateur;

    @OneToOne
    private Evenement evenement;
}
