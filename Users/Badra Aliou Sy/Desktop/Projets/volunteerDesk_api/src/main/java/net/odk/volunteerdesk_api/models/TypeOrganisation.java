package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class TypeOrganisation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeOrganisation;

    private  String libelleTypeOrganisation;

    @OneToMany(mappedBy = "typeOrganisation")
    private List<Organisation> organisations;
}
