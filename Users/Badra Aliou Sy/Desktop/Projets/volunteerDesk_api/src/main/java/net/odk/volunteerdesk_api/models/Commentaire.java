package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Commentaire {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCommentaire;
    private String contenuCommentaire;
    @Column(nullable = false)
    private Date dateCommentaire;



}
