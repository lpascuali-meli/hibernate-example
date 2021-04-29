package meli.bootcamp.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Dentist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @OneToMany(mappedBy="dentist")
    @ToString.Exclude
    @JsonIgnore
    private Set<Appointment> appointments;

}
