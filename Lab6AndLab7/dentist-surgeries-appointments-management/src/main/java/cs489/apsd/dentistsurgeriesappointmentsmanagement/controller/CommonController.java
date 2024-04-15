package cs489.apsd.dentistsurgeriesappointmentsmanagement.controller;

import cs489.apsd.dentistsurgeriesappointmentsmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/hello")
    public double hello() {
        return "hello";
    }

    @GetMapping(path = "/adsweb/api/v1/patient/list")
    public String message(@PathVariable Long patientId) {
        String patientName = patientService.findById(patientId);
        producer.send(patientName);
        return patientName;
    }
}
