package tn.esprit.medecin.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Clinique {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long IdClinique;
    private String nomClinique;
    private String adresse;
    private Integer telephone;
    @ManyToMany
    private List<Medecin> medecins;

}
