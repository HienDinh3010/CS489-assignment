package cs489.apsd.dentistsurgeriesappointmentsmanagement.dto;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Address;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPatientDTO {
    private Address address;
    private Patient patient;
}
