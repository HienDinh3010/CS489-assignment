package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;


import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
