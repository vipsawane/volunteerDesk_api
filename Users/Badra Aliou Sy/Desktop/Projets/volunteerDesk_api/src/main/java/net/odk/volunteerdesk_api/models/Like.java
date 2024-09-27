package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLike;

    private Integer nbrLike;
}
