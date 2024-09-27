package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Ressouce {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idRessource;
    @Column(nullable = false)
    private String imageRessource;
    private String libelleRessource;
    private String contenuRessource;
    @Column(nullable = false)
    private Integer likeRessource;
    @Column(nullable = false)
    private String commentaireRessource;
}
