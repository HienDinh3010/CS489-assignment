package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Patient;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
