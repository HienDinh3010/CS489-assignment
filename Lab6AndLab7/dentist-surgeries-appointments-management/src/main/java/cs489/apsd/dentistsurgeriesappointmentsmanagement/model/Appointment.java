package cs489.apsd.dentistsurgeriesappointmentsmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "dentistId")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "surgeryId")
    private Surgery surgery;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime appointmentDate;

    private String surgeryLocation;

    public Appointment(Dentist dentist, Patient patient, Surgery surgery, LocalDateTime appointmentDate, String surgeryLocation) {
        this.dentist = dentist;
        this.patient = patient;
        this.surgery = surgery;
        this.appointmentDate = appointmentDate;
        this.surgeryLocation = surgeryLocation;
    }
}
