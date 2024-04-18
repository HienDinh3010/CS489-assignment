package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
