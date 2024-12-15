package tn.esprit.medecin.service;

import tn.esprit.medecin.entity.*;

import java.util.Date;
import java.util.List;

public interface ServiceExamen {
    Clinique addClinique (Clinique clinique);
    Medecin addMedecinAndAssignToClinique(Medecin medecin , Long IdClinique);

    Patient addPatient(Patient patient);

    RendezVous addRDVandAssignMedAndPatient(RendezVous rendezVous, Long idMedecin , Long idPatient);

    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long IdClinique, Specialite specialite);

    int getNbrRendezVousMedecin(Long idMedecin);

    int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
