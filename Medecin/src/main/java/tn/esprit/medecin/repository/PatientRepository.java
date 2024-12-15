package tn.esprit.medecin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.medecin.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
