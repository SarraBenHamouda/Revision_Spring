package tn.esprit.medecin.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRdv;
    Date dateRdv;
    String remarque;
    @ManyToOne
    Medecin Med;
    @ManyToOne
    Patient Patient;


}
