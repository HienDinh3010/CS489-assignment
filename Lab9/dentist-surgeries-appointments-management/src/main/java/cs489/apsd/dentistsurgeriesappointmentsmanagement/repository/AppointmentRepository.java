package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
