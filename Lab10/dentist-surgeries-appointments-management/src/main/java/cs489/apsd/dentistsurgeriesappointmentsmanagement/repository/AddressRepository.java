package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.AddressPatientDTO;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a LEFT JOIN FETCH a.patient ORDER BY a.city ASC")
    List<Address> findAllAddressesWithPatientsSortedByCity1();

    @Query("SELECT new cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.AddressPatientDTO(a, a.patient) FROM Address a ORDER BY a.city ASC")
    List<AddressPatientDTO> findAllAddressesWithPatientsSortedByCity();
}
