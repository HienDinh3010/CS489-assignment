package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Appointment;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
