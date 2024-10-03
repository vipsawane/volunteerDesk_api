package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class StatutMessage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatutMessage;

    private String libelleStatutMessage;

    @OneToMany(mappedBy = "statutMessage")
    private List<Message> messages;


}
