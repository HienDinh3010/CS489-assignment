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
@Table(name = "surgery")
public class Surgery {

    public Surgery(String name, Address address, String telephoneNumber) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    private String telephoneNumber;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
