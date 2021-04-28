package meli.bootcamp.hibernate.repositories;

import meli.bootcamp.hibernate.entities.Appointment;
import meli.bootcamp.hibernate.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
