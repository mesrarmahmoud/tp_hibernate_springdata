package ma.enset.tp_patient.repository;

import ma.enset.tp_patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
