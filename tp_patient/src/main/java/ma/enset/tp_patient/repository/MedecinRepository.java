package ma.enset.tp_patient.repository;

import ma.enset.tp_patient.entities.Medecin;
import ma.enset.tp_patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);

}
