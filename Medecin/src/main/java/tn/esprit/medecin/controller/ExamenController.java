package tn.esprit.medecin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.medecin.entity.*;
import tn.esprit.medecin.service.ServiceExamen;

import java.util.Date;
import java.util.List;

@RestController
public class ExamenController {
    @Autowired
    private ServiceExamen serviceExamen;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return serviceExamen.addClinique(clinique);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{IdClinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long IdClinique) {
        return serviceExamen.addMedecinAndAssignToClinique(medecin, IdClinique);
    }

    @PostMapping("/ addRDVandAssignMedAndPatient/{idMedecin}/{idPatient}")
    public RendezVous addRDVandAssignMedAndPatient(@RequestBody RendezVous rendezVous, @PathVariable Long idMedecin, @PathVariable Long idPatient) {
        return serviceExamen.addRDVandAssignMedAndPatient(rendezVous, idMedecin, idPatient);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return serviceExamen.addPatient(patient);
    }


    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{IdClinque}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long IdClinque, @PathVariable Specialite specialite) {
        return serviceExamen.getRendezVousByCliniqueAndSpecialite(IdClinque, specialite);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin) {
        return serviceExamen.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/getRevenue/{IdMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable Long idMedecin, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return serviceExamen.getRevenuMedecin(idMedecin, startDate, endDate);
    }

}
