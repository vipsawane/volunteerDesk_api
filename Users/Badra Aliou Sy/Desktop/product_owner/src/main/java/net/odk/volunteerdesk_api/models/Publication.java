package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPublication;
    @Column(nullable = false)
    private String imagePublication;
    private String contenuPublication;
    @Column(nullable = false)
    private Date datePublication;
}
