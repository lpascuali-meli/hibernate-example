package meli.bootcamp.hibernate.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Dentist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @OneToMany(mappedBy="dentist")
    private Set<Appointment> appointments;

}
