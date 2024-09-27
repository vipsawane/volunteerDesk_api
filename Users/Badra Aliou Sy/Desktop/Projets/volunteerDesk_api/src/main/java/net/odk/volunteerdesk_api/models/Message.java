package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMessage;
    @Column(nullable = false)
    private String imageMessage;
    private String contenuMessage;
    @Column(nullable = false)
    private String statutMessage;
}
