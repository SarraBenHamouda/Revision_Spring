package tn.esprit.medecin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.medecin.entity.Clinique;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
}
