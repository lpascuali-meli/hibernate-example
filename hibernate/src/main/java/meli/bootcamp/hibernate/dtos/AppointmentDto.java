package meli.bootcamp.hibernate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AppointmentDto {
    private Long dentistId;
    private Long patientId;
    private LocalDate date;
}
