package cs489.apsd.dentistsurgeriesappointmentsmanagement;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.model.*;
import cs489.apsd.dentistsurgeriesappointmentsmanagement.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DentistSurgeriesAppointmentsManagementApplication implements CommandLineRunner
{

    private AppointmentService appointmentService;

    private DentistService dentistService;

    private SurgeryService surgeryService;

    private PatientService patientService;

    private RoleService roleService;

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DentistSurgeriesAppointmentsManagementApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Autowired
    public void setDentistService(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @Autowired
    public void setSurgeryService(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentistSurgeriesAppointmentsManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "user1", passwordEncoder.encode("password"), null);
        User user2 = new User(null, "user2", passwordEncoder.encode("password"), null);
        User user3 = new User(null, "user3", passwordEncoder.encode("password"), null);
        Role role1 = new Role(null, "DENTIST", user1, null, null);
        Role role2 = new Role(null, "PATIENT", user2, null, null);
        Role role3 = new Role(null, "OFFICE", user3, null, null);
        roleService.save(role1);
        roleService.save(role2);
        roleService.save(role3);

        Dentist tony = new Dentist("Tony", "Smith", "(641) 233-9100",
                "tonysmith@gmail.com", "White teeth");

        Dentist helen = new Dentist("Helen", "Pearson", "(641) 233-9999",
                "helen@gmail.com", "Broken teeth");

        Dentist robin = new Dentist("Robin", "Plevin", "(641) 233-1100",
                "robin@gmail.com", "Yellow teeth");

        dentistService.add(tony);
        dentistService.add(helen);
        dentistService.add(robin);

        Surgery s15 = new Surgery("S15", new Address("12415 Burlington", "Iowa", "52556"),
                "(641) 233-9115");

        Surgery s10 = new Surgery("S10", new Address("10 Burlington", "Iowa", "52556"),
                "(641) 233-9110");

        Surgery s13 = new Surgery("S13", new Address("12413 Burlington", "Iowa", "52556"),
                "(641) 233-9113");

        surgeryService.add(s15);
        surgeryService.add(s10);
        surgeryService.add(s13);

        Patient gillian = new Patient("Gillian", "White", "(641) 233-9111", "gilian@gmail.com",
                new Address("123 Main", "Iowa", "52556"), new Date(90, 0, 1));

        Patient jill = new Patient("Jill", "Bell", "(641) 233-9222", "jill@gmail.com",
                new Address("001234 Main", "Iowa", "52556"), new Date(96, 0, 23));

        Patient ian = new Patient("Ian", "Mackay", "(641) 233-9333", "ian@gmail.com",
                new Address("21101 Ian Main", "Iowa", "52556"), new Date(95, 0, 24));

        Patient john = new Patient("John", "Walker", "(641) 233-3333", "john@gmail.com",
                new Address("11101 John Main", "Iowa", "52556"), new Date(99, 0, 23));

        patientService.add(gillian);
        patientService.add(jill);
        patientService.add(ian);
        patientService.add(john);

        Appointment appointment = new Appointment(tony, gillian, s15,
                LocalDateTime.of(2023, 4, 12, 15, 30), "Fairfield");

        Appointment appointment2 = new Appointment(tony, jill, s15,
                LocalDateTime.of(2024, 4, 12, 15, 30), "Fairfield");

        Appointment appointment3 = new Appointment(helen, ian, s10,
                LocalDateTime.of(2024, 5, 12, 15, 30), "Chicago");

        Appointment appointment4 = new Appointment(helen, ian, s10,
                LocalDateTime.of(2024, 6, 12, 15, 30), "Chicago");

        Appointment appointment5 = new Appointment(robin, jill, s15,
                LocalDateTime.of(2024, 8, 14, 15, 30), "Fairfield");

        Appointment appointment6 = new Appointment(robin, john, s13,
                LocalDateTime.of(2024, 10, 12, 15, 30), "Des Moise");

        appointmentService.save(appointment);
        appointmentService.save(appointment2);
        appointmentService.save(appointment3);
        appointmentService.save(appointment4);
        appointmentService.save(appointment5);
        appointmentService.save(appointment6);

        role1.setDentist(tony);
        roleService.save(role1);
        role2.setPatient(gillian);
        roleService.save(role2);
    }
//
//    @PostConstruct
//    public void initAdminUser() {
//        var adminUser = userService.findByUsername("admin");
//        if(adminUser.isEmpty()) {
//            List<Role> listAdminRoles = new ArrayList<>();
//            var adminRole = roleService.findByName("ROLE_ADMIN");
//            if(adminRole.isEmpty()) {
//                var newAdminRole =  new Role(null, "ROLE_ADMIN");
//                listAdminRoles.add(newAdminRole);
//            } else {
//                listAdminRoles.add(adminRole.get());
//            }
//            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
//                    passwordEncoder.encode("test1234"), "admin@dsam.com",
//                    true,true, true, true);
//            newAdminUser.setRoles(listAdminRoles);
//            userService.save(newAdminUser);
//        }
//    }
}
