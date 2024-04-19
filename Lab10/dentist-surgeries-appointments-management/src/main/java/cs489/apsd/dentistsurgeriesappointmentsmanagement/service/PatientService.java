package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.exception.PatientNotFoundException;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Patient;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void add(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void update(Patient patient) {
        Patient retrievedPatient = findById(patient.getPatientId());
        if (retrievedPatient != null) {
            patientRepository.save(patient);
        }
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> getPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }


    public Patient updatePatient(Long patientId, Patient patientDetails) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));

        // Update patient details
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        // Update other fields as needed

        return patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));

        patientRepository.delete(patient);
    }


    public List<Patient> searchPatients(String searchString) {
        return patientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchString, searchString);
    }


    public List<Patient> getAllPatientsWithPrimaryAddressesSortedByLastName() {
        return patientRepository.findAllPatientsWithPrimaryAddressesSortedByLastName();
    }
}
