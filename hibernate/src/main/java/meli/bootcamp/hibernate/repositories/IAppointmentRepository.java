package meli.bootcamp.hibernate.repositories;

import meli.bootcamp.hibernate.entities.Appointment;
import meli.bootcamp.hibernate.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("from Appointment a where  a.dentist.id = :dentist")
    List<Appointment> findAppointmentByDentist(@Param("dentist") Long dentist);

}
