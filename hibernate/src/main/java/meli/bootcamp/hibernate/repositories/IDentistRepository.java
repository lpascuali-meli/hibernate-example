package meli.bootcamp.hibernate.repositories;

import meli.bootcamp.hibernate.entities.Dentist;
import meli.bootcamp.hibernate.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {


}
