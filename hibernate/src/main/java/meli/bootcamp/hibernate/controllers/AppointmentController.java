package meli.bootcamp.hibernate.controllers;

import meli.bootcamp.hibernate.dtos.AppointmentDto;
import meli.bootcamp.hibernate.services.IAppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    private ResponseEntity saveAppointment(@RequestBody AppointmentDto appointmentDto){
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.ok().body(appointmentDto);
    }


    @GetMapping("/{id}")
    private ResponseEntity findAppointment(@PathVariable Long id){
        return ResponseEntity.ok().body(appointmentService.findAppointment(id));
    }

    @PutMapping()
    private ResponseEntity update(@RequestBody AppointmentDto appointmentDto){
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    private ResponseEntity getAll(){
        return ResponseEntity.ok().body(appointmentService.getAppointments());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/agenda/{id}")
    private ResponseEntity findDentistAgenda(@PathVariable Long id){
        return ResponseEntity.ok().body(appointmentService.getAgendaByDentistId(id));
    }
}
