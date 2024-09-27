package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "idEvenement")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Mentorat extends Evenement{

    private String Formateur;
}
