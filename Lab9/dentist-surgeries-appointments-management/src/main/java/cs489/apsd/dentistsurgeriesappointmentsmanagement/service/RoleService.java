package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.Role;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void save(Role role) {
        roleRepository.save(role);
    }
}
