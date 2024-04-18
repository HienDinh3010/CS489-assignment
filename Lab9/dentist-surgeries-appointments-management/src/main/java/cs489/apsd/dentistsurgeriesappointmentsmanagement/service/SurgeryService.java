package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Surgery;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryService {

    private SurgeryRepository surgeryRepository;

    @Autowired
    public void setSurgeryRepository(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public void add(Surgery surgery) {
        surgeryRepository.save(surgery);
    }

    public Surgery findById(Long id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    public List<Surgery> findAll() {
        return surgeryRepository.findAll();
    }

    public void update(Surgery surgery) {
        Surgery retrievedSurgery = findById(surgery.getSurgeryId());
        if (retrievedSurgery != null) {
            surgeryRepository.save(surgery);
        }
    }

    public void delete(Long id) {
        surgeryRepository.deleteById(id);
    }
}
