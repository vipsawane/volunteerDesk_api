package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    private String libelleRole;

}
