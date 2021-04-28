package meli.bootcamp.hibernate.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Dentist {
    @Id
    private Long id;
    private String name;
    private String lastName;
    @OneToMany(mappedBy="dentist")
    private Set<Appointment> appointments;

}
