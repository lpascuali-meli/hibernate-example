package meli.bootcamp.hibernate.services;

import java.util.List;
import meli.bootcamp.hibernate.dtos.AppointmentDto;


public interface IAppointmentService {
    void saveAppointment(AppointmentDto appointment);
    void deleteAppointment(Long id);
    AppointmentDto findAppointment(Long id);
    List<AppointmentDto> getAppointments();
}
