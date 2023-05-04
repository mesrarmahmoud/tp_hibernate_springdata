package ma.enset.tp_patient.repository;

import ma.enset.tp_patient.entities.Medecin;
import ma.enset.tp_patient.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}
