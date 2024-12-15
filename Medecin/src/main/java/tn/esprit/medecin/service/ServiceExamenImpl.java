package tn.esprit.medecin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.medecin.entity.*;
import tn.esprit.medecin.repository.CliniqueRepository;
import tn.esprit.medecin.repository.MedecinRepository;
import tn.esprit.medecin.repository.PatientRepository;
import tn.esprit.medecin.repository.RendezVousRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceExamenImpl implements ServiceExamen {

    @Autowired
    private CliniqueRepository cliniqueRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long idClinique) {
        Clinique clinique = cliniqueRepository.findById(idClinique).orElse(null);
        if (clinique != null) {
            List<Medecin> list = clinique.getMedecins() == null ? new ArrayList<>() : clinique.getMedecins();
            list.add(medecin);
            clinique.setMedecins(list);
            cliniqueRepository.save(clinique);
        }
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public RendezVous addRDVandAssignMedAndPatient(RendezVous rendezVous, Long idMedecin, Long idPatient) {
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        Patient p = patientRepository.findById(idPatient).orElse(null);
        rendezVous.setPatient(p);
        rendezVous.setMed(m);
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long IdClinique, Specialite specialite) {
        Clinique c = cliniqueRepository.findById(IdClinique).orElse(null);
        List<RendezVous> list = rendezVousRepository.findAll();
        List<RendezVous> resultat = new ArrayList<>();
        for (RendezVous r : list) {
            Medecin m = r.getMed();
            if (r.getMed().getCliniques() != null) {
                for (Clinique cc : r.getMed().getCliniques()) {
                    if (c.equals(cc) && m.getSpecialite().equals(specialite))
                    {
                        resultat.add(r);
                    }
                }
            }
        }
        return resultat; // Added the return statement here
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        int nb = 0;
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list=rendezVousRepository.findAll();
        for(RendezVous r:list) {
            if(r.getMed().equals(m)) {
                nb++;
            }
        }
        return nb;


    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        int nb = 0 ;
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list=rendezVousRepository.findAll();
        for (RendezVous r : list) {
            if (r.getMed().equals(m) && r.getDateRdv().after(startDate) && r.getDateRdv().before(endDate));
            nb++;
        }
        return m.getPrix()*nb;
    }

    @Scheduled(cron = "*/30 * * * * *")
    void RetrieveRendezVous(){
        List<RendezVous> list=rendezVousRepository.findAll();
    for (RendezVous r :list) {
        if (r.getDateRdv().after(new Date())){

            log.info("la liste des rendezVous :"+r.getIdRdv()+" : Medecin:"+r.getMed().getNomMedecin()+" : Patient:"+r.getPatient().getNomPatient());
        }

    }
    }
}
