package cs489.apsd.dentistsurgeriesappointmentsmanagement.controller;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.exception.PatientNotFoundException;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Address;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Patient;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatientsWithPrimaryAddressesSortedByLastName();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Long patientId) {
        Optional<Patient> patient = patientService.getPatientById(patientId);
        if (patient.isPresent()) {
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient registeredPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(registeredPatient, HttpStatus.CREATED);
    }

    @PutMapping("/update/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable Long patientId, @RequestBody Patient patientDetails) throws PatientNotFoundException {
        Patient updatedPatient = patientService.updatePatient(patientId, patientDetails);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Long patientId) {
        try {
            patientService.deletePatient(patientId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatients(@PathVariable String searchString) {
        List<Patient> searchResults = patientService.searchPatients(searchString);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

}
