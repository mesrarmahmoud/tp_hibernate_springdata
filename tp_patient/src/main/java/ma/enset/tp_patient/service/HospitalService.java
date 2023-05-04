package ma.enset.tp_patient.service;

import ma.enset.tp_patient.entities.Consultation;
import ma.enset.tp_patient.entities.Medecin;
import ma.enset.tp_patient.entities.Patient;
import ma.enset.tp_patient.entities.RendezVous;

public interface HospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
