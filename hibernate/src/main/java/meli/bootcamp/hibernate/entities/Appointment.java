package meli.bootcamp.hibernate.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="dentist_id", nullable=false)
    private Dentist dentist;
    private Date date;

}
