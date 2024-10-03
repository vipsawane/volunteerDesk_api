package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Sanction{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idSanction;
    private String libelleSanction;
    private String motifSanction;

    @OneToMany(mappedBy = "sanction")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "sanction")
    @JsonIgnore
    private List<Organisation> organisations;
}
