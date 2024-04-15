package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.AddressPatientDTO;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Address;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddressesWithPatientsSortedByCity1() {
        return addressRepository.findAllAddressesWithPatientsSortedByCity1();
    }

    public List<AddressPatientDTO> getAllAddressesWithPatientsSortedByCity() {
        return addressRepository.findAllAddressesWithPatientsSortedByCity();
    }
}
