package ma.enset.tp_patient.repository;

import ma.enset.tp_patient.entities.Consultation;
import ma.enset.tp_patient.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
