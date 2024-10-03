package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeEvenement;

    @Column(nullable = false)
    private  String libelleTypeEvenement;

    @OneToMany
    @JsonIgnore
    private List<Evenement> evenement;
}
