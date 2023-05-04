package ma.enset.tp_patient;

import ma.enset.tp_patient.entities.Medecin;
import ma.enset.tp_patient.entities.Patient;
import ma.enset.tp_patient.entities.RendezVous;
import ma.enset.tp_patient.entities.StatusRDV;

import ma.enset.tp_patient.repository.MedecinRepository;
import ma.enset.tp_patient.repository.PatientRepository;
import ma.enset.tp_patient.repository.RendezVousRepository;
import ma.enset.tp_patient.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class TpPatientApplication  implements CommandLineRunner {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private  RendezVousRepository rendezVousRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    public static void main(String[] args) {
        SpringApplication.run(TpPatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        hospitalService.savePatient(new Patient(null,"patient1",new Date(),true,33, null));
        hospitalService.savePatient(new Patient(null,"patient2",new Date(),false,35 , null));
        hospitalService.savePatient(new Patient(null,"patient2",new Date(),true,3 , null));

        Stream.of("Mohamed", "hassan","najat").forEach(name->{
            Patient patient = new Patient();
            patient.setNom(name);
            patient.setMalade(false);
            patient.setDateNaissance(new Date());
            hospitalService.savePatient(patient);
        });
        Stream.of("yahya", "nisrine","khaoula").forEach(name->{
            Medecin medecin = new Medecin();
            medecin.setNom(name);
            medecin.setEmail(name+"@gmail.com");
            medecin.setSpecialite(Math.random()>0.5?"Cardio" : "Dentiste");
            hospitalService.saveMedecin(medecin);
        });

        List<Patient> patients = patientRepository.findAll();
        System.out.println("- Consulter tous les patients");
        patients.forEach(patient -> {
            System.out.println(patient.getNom());
        });
        System.out.println("********************");
        System.out.println("Consulter un patient");
        Patient patient = patientRepository.findById(Long.valueOf(1)).get();
        System.out.println(patient.getNom());
        System.out.println("********************");
        System.out.println("Rechercher des patients");

        System.out.println("********************");
        System.out.println("Modifier un patient");

        Patient updatedPatient = patientRepository.findById(Long.valueOf(2)).get();
        updatedPatient.setNom("updatedName");
        patientRepository.save(updatedPatient);
        System.out.println(updatedPatient.getNom());

        System.out.println("********************");
        System.out.println("Supprimer un patient");
        patientRepository.deleteById(patient.getId());
        List<Patient> patients1 = patientRepository.findAll();
        patients1.forEach(p -> {
            System.out.println(p.getId() + " Nom est : " + p.getNom());
        });

        Patient patient2 = patientRepository.findById(Long.valueOf(3)).get();
        Medecin medecin = medecinRepository.findById(Long.valueOf(1)).get();

        RendezVous rendezVous = new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);

        rendezVous.setPatient(patient2);
        rendezVous.setMedecin(medecin);

        rendezVousRepository.save(rendezVous);

    }
}
