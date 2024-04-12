package cs489.apsd.dentistsurgeriesappointmentsmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    public Dentist(String firstName, String lastName, String phone, String email, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
    }

    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;
}
