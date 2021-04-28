package meli.bootcamp.hibernate.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.entities.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import meli.bootcamp.hibernate.dtos.AppointmentDto;
import meli.bootcamp.hibernate.repositories.IAppointmentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppointmentService implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    @Transactional
    public void saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new ObjectMapper().convertValue(appointmentDto,Appointment.class);
        this.appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(Long id) {
        this.appointmentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public AppointmentDto findAppointment(Long id) {
        Appointment appointment = this.appointmentRepository.findById(id).orElse(null);
        AppointmentDto appointmentDto = new ObjectMapper().convertValue(appointment,AppointmentDto.class);
        return appointmentDto;
    }

    @Override
    @Transactional
    public List<AppointmentDto> getAppointments() {
        ObjectMapper mapper = new ObjectMapper();
        return this.appointmentRepository.findAll().stream().map(appointment -> mapper.convertValue(appointment,AppointmentDto.class)).collect(Collectors.toList());
    }

}
