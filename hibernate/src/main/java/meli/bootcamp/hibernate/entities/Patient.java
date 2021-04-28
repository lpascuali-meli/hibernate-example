package meli.bootcamp.hibernate.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Patient {
    @Id
    private Long id;
    private String name;
    private String lastName;
    @OneToMany(mappedBy="patient")
    private Set<Appointment> appointments;

}
