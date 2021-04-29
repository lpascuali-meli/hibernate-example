package meli.bootcamp.hibernate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.dtos.DentistDto;
import meli.bootcamp.hibernate.dtos.PatientDTO;
import meli.bootcamp.hibernate.entities.Patient;
import meli.bootcamp.hibernate.services.IPatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    private ResponseEntity savePatient(@RequestBody PatientDTO patient){
        patientService.savePatient(patient);
        return ResponseEntity.ok().body("Successfully added: \n" + patient.toString());
    }

    @GetMapping("/{id}")
    private ResponseEntity findPatient(@PathVariable Long id){
        return ResponseEntity.ok().body(patientService.getPatientById(id));
    }

    @PutMapping()
    private ResponseEntity update2(@RequestBody PatientDTO patient){
        patientService.savePatient(patient);
        return ResponseEntity.ok().body("Succesfully updated patient with id: " + patient.getId());
    }

    @GetMapping
    private ResponseEntity getAll(){
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("Successfully deleted patient with id:" + id);
    }

    @GetMapping("/today")
    private ResponseEntity findPatientsToday(){
        return ResponseEntity.ok().body(patientService.findTodayPatients());
    }

}
