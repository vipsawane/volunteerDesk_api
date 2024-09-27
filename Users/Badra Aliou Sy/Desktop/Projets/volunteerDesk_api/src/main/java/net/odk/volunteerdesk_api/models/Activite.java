package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "idEvenement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Activite extends Evenement{

    @Column(nullable = false)
    private String organisateur;
    private String cible;

}
