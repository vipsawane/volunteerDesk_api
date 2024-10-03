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
    @Column(nullable = false, unique = true)
    private String numCarteIdentite;
    private String photoCarteIdentite;
    private String competences;
    private int anneeExperience;
    @Column(nullable = false)
    private int nbrSuspension;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "idSanction")
    private Sanction sanction;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "idCandidature")
    private Candidature candidature;
}
