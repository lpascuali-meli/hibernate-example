package meli.bootcamp.hibernate.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.entities.Appointment;
import meli.bootcamp.hibernate.repositories.IDentistRepository;
import meli.bootcamp.hibernate.repositories.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import meli.bootcamp.hibernate.dtos.AppointmentDto;
import meli.bootcamp.hibernate.repositories.IAppointmentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppointmentService implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;
    private final IDentistRepository dentistRepository;
    private final IPatientRepository patientRepository;


    public AppointmentService(IAppointmentRepository appointmentRepository, IDentistRepository dentistRepository, IPatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void saveAppointment(AppointmentDto appointmentDto) {
        // Appointment appointment = new ObjectMapper().convertValue(appointmentDto,Appointment.class);
        Appointment appointment = new Appointment();
        appointment.setPatient(patientRepository.findById(appointmentDto.getPatient_id()).orElse(null));
        appointment.setDentist(dentistRepository.findById(appointmentDto.getDentist_id()).orElse(null));
        appointment.setDate(appointmentDto.getDate());
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
        return this.appointmentRepository.findAll().stream().map(ap -> new ModelMapper().map(ap, AppointmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAgendaByDentistId(Long id) {
        return appointmentRepository.findAppointmentByDentist(id).stream().map(ap -> new ModelMapper().map(ap, AppointmentDto.class)).collect(Collectors.toList());
    }

}
