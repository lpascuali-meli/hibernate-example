package meli.bootcamp.hibernate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.bootcamp.hibernate.entities.Appointment;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private Set<Appointment> appointments;
}
