package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMessage;
    @Column(nullable = false)
    private String imageMessage;
    private String contenuMessage;
    @Column(nullable = false)
    private String DateMessage;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name="idOrganisation")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "idStatutMessage")
    private StatutMessage statutMessage;


}
