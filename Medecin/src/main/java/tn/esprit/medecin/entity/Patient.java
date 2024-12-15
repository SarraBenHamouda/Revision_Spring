package tn.esprit.medecin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatient;
    String nomPatient;

    Integer telephone;

    Date datenaissance;

    @OneToMany (mappedBy = "Patient")
    private List<RendezVous> rendezVous;


}
