package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Organisation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idOrganisation;

    private String numeroIdentification;
    private String raisonSocial;
    private String description;
    private String siege;
    private String domaineActivite;
    private Date dateCreation;
    @Column(nullable = false)
    private Integer nbrSanction;



}
