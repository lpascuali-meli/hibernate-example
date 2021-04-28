package meli.bootcamp.hibernate.controllers;

import meli.bootcamp.hibernate.dtos.DentistDto;
import meli.bootcamp.hibernate.services.IDentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    
    private IDentistService dentistService;

    public DentistController(IDentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping
    private ResponseEntity saveDentist(@RequestBody DentistDto dentistDto){
        dentistService.saveDentist(dentistDto);
        return ResponseEntity.ok().body("Dentist created successfuly");
    }


    @GetMapping("/{id}")
    private ResponseEntity findDentist(@PathVariable Long id){
        return ResponseEntity.ok().body(dentistService.getDentistById(id));
    }

    @PutMapping()
    private ResponseEntity update(@RequestBody DentistDto dentistDto){
        dentistService.saveDentist(dentistDto);
        return ResponseEntity.ok().body("Succesfully updated");
    }

    @GetMapping
    private ResponseEntity getAll(){
        return ResponseEntity.ok().body(dentistService.getDentists());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        dentistService.deleteDentist(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }


}
