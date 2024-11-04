package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;


    private String nomUser;
    private String prenomUser;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private String photoUser;
    @Column(nullable = false)
    private String description;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    private Date dateNaissance;
    @Column(nullable = false, unique = true)
    private String numCarteIdentite;
    @Column(nullable = false)
    private String photoCarteIdentite;
    @Column(nullable = false)
    private String competences;
    @Column(nullable = false)
    private int anneeExperience;
    @Column(nullable = false)
    private int nbrSuspension;
    @Column(nullable = false)
    private Boolean isConnected;
    @Column(nullable = false)
    private Boolean actived;


    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "idSanction")
    private Sanction sanction;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "idCandidature")
    private Candidature candidature;

    @OneToMany(mappedBy = "user")
    private List<Publication> publications;

    @OneToMany(mappedBy = "user")
    private List<Ressource> ressources;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getLibelleRole())));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
