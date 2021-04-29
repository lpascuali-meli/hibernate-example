package meli.bootcamp.hibernate.repositories;

import meli.bootcamp.hibernate.entities.Dentist;
import meli.bootcamp.hibernate.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("from Patient p INNER JOIN Appointment a on a.patient.id=p.id where  :date = year(a.date) month(a.date) day(a.date)to_char(a.date, 'dd/MM/yyyy') ")
    List<Patient> findPatientByDate(@Param("date")String date);
}
