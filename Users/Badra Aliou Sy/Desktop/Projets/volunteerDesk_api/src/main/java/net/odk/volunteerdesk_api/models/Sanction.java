package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Sanction{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idSanction;
    private String libelleSanction;
    private String motifSanction;
}
