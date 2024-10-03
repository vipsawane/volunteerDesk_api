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
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;

    @Column(nullable = false)
    private String libelleCandidature;

    @Column(nullable = false)
    private String etatCandidature;

    @Column(nullable = false)
    private String dateCandidature;
}
