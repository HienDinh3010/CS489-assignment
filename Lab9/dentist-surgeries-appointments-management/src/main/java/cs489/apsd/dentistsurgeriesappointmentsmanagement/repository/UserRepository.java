package cs489.apsd.dentistsurgeriesappointmentsmanagement.repository;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public abstract Optional<User> findByUsername(String username);

}
