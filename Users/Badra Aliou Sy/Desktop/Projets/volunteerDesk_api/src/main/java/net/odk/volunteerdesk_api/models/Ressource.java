package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Ressource {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idRessource;
    @Column(nullable = false)
    private String imageRessource;
    private String libelleRessource;
    private String contenuRessource;
    private int likeRessource;

//    @OneToMany(mappedBy = "ressource")
//    @JsonIgnore
//    private List<Like> like;

    @OneToMany(mappedBy = "ressource")
    @JsonIgnore
    private List<Commentaire> commentaire;

}
