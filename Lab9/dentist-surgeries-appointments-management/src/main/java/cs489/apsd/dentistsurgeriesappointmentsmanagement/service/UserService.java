package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.User;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
