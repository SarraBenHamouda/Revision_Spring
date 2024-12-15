package tn.esprit.medecin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.medecin.entity.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
