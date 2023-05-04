package ma.enset.tp_patient.service;

import jakarta.transaction.Transactional;
import ma.enset.tp_patient.entities.Consultation;
import ma.enset.tp_patient.entities.Medecin;
import ma.enset.tp_patient.entities.Patient;
import ma.enset.tp_patient.entities.RendezVous;
import ma.enset.tp_patient.repository.ConsultationRepository;
import ma.enset.tp_patient.repository.MedecinRepository;
import ma.enset.tp_patient.repository.PatientRepository;
import ma.enset.tp_patient.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save((patient));
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
