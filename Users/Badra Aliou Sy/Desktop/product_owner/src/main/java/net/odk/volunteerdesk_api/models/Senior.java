package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "idUser")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Senior extends User {

    private String numCarteIdentification;
    private String photoCarteIdentificationNationale;
    private String profil;
    private String competences;
    private Date anneeExperiences;
    @Column(nullable = false)
    private Integer nbrSuspension;
    @Column(nullable = false)
    private String CV;



}
