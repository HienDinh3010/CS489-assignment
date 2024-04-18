package cs489.apsd.dentistsurgeriesappointmentsmanagement.service;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.User;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DSAMUserDetailsService implements UserDetailsService {

    public DSAMUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found for " + username));
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(AuthorityUtils.createAuthorityList(user.getRoleNames()))
                .build();
        return userDetails;
    }

}
