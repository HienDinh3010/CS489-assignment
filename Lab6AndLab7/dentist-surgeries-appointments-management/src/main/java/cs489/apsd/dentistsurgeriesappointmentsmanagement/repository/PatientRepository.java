package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //@Query("SELECT p FROM Patient p ORDER BY p.lastName ASC")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.address ORDER BY p.lastName ASC")
    List<Patient> findAllPatientsWithPrimaryAddressesSortedByLastName();

    Patient findByPatientId(Long patientId);
    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}
