package meli.bootcamp.hibernate.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Appointment {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="dentist_id", nullable=false)
    private Dentist dentist;
    private LocalDate date;

}
