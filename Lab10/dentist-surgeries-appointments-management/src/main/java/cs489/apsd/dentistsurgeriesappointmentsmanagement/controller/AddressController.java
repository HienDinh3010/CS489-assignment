package cs489.apsd.dentistsurgeriesappointmentsmanagement.controller;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.AddressPatientDTO;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Address;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @Autowired
    private AddressService addressService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Address>> getAllAddresses() {
//        List<Address> addresses = addressService.getAllAddressesWithPatientsSortedByCity1();
//        //List<Address> addresses = addressService.findAllAddressesSortedByCity();
//        return new ResponseEntity<>(addresses, HttpStatus.OK);
//    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressPatientDTO>> getAllAddresses() {
        List<AddressPatientDTO> addressPatientDTOs = addressService.getAllAddressesWithPatientsSortedByCity();
        return new ResponseEntity<>(addressPatientDTOs, HttpStatus.OK);
    }
}
