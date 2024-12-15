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
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite Specialite;
    private Integer telephone;
    private Integer prix;
    @ManyToMany(mappedBy = "medecins")
    private List<Clinique> cliniques;
    @OneToMany(mappedBy = "Med")
    private List<RendezVous> rendezVous;
}
