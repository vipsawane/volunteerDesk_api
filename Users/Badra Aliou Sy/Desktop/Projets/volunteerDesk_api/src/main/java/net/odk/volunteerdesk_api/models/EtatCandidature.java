package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EtatCandidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatCandidature;

    private String libelleEtatCandidature;

    @OneToMany(mappedBy = "etatCandidature")
    @JsonIgnore
    private List<Candidature> candidature;
}
