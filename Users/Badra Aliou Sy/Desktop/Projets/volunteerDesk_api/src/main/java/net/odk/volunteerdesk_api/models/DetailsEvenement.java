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



    private Boolean participation = true;

    @Column(nullable = false)
    private int nbrCandidat;


    @Column(nullable = true)
    private String Formateur;

    @OneToOne
    private Evenement evenement;

}
