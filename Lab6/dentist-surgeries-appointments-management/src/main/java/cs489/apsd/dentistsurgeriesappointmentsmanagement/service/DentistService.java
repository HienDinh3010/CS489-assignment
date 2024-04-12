package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Dentist;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    private DentistRepository dentistRepository;

    @Autowired
    public void setDentistRepository(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void add(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public Dentist findById(Long id) {
        return dentistRepository.findById(id).orElse(null);
    }

    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    public void update(Dentist dentist) {
        Dentist retrievedDentist = findById(dentist.getDentistId());
        if (retrievedDentist != null) {
            dentistRepository.save(dentist);
        }
    }

    public void delete(Long id) {
        dentistRepository.deleteById(id);
    }
}
