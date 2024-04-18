package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public abstract Optional<Role> findByName(String name);

}
