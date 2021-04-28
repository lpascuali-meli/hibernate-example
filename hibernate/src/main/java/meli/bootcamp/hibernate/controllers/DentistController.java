package meli.bootcamp.hibernate.controllers;

import meli.bootcamp.hibernate.entities.Dentist;
import meli.bootcamp.hibernate.services.IdentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    
    private IdentistService dentistService;

    public DentistController(IdentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping
    private ResponseEntity saveDentist(@RequestBody Dentist dentist){
        dentistService.saveDentist(dentist);
        return ResponseEntity.ok().body(Dentist);
    }


    @GetMapping("/{id}")
    private ResponseEntity findDentist(@PathVariable Long id){
        return ResponseEntity.ok().body(dentistService.getDentistById(id));
    }

    @PutMapping()
    private ResponseEntity update2(@RequestBody Dentist Dentist){
        dentistService.saveDentist(Dentist);
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
