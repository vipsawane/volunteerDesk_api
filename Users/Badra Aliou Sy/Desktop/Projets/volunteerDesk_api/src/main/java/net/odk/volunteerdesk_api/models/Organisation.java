package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Organisation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrganisation;

    private String numeroIdentification;
    private String raisonSocial;
    private String description;
    private String siege;
    private String domaineActivite;
    private String dateCreation;
    @Column(nullable = false)
    private Integer nbrSanction;

    @OneToMany(mappedBy = "organisation")
    @JsonIgnore
    private List<Evenement> evenement;

    @ManyToOne
    @JoinColumn(name = "idSanction")
    private Sanction sanction;

    @ManyToOne
    @JoinColumn(name = "idTypeOrganisation")
    private TypeOrganisation typeOrganisation;

    @OneToMany(mappedBy = "organisation")
    @JsonIgnore
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "idCandidature")
    private Candidature candidature;



}
