package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPublication;
    @Column(nullable = false)
    private String imagePublication;
    private String contenuPublication;
    @Column(nullable = false)
    private String datePublication;
    @Column(nullable = false)
    private int likePublication;

    @OneToMany(mappedBy = "publication")
    @JsonIgnore
    private List<Commentaire> commentaire;
}
