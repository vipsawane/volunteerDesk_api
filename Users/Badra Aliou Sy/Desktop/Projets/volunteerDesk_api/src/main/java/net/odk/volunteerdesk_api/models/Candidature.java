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

    @OneToMany(mappedBy = "candidature")
    @JsonIgnore
    private List<User> user;

    @OneToMany(mappedBy = "candidature")
    @JsonIgnore
    private List<Organisation> organisations;

    @ManyToOne
    @JoinColumn(name = "idEvenement")
    private Evenement evenement;






}
