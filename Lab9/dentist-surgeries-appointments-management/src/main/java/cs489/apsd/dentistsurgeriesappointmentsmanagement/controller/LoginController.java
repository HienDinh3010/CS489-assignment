package cs489.apsd.dentistsurgeriesappointmentsmanagement.controller;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.LoginRequest;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.dto.LoginResponse;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.utils.JwtUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("adsweb/api/v1")
public class LoginController {
    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private JwtUtilityService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest user) {
        var userDetail = userDetailService.loadUserByUsername(user.username());
        var password = userDetail.getPassword();
        if (!passwordEncoder.matches(user.password(), password)) {
            throw new BadCredentialsException("Invalid username or password");
        }

        String[] roleNames = userDetail.getAuthorities()
            .stream().map(a -> a.getAuthority()).toArray(String[]::new);
        var token = jwtService.generateToken(user.username(), roleNames);
        var response = new LoginResponse(token); 
        return ResponseEntity.ok(response);
    }
}
