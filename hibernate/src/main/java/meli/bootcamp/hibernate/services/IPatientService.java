package meli.bootcamp.hibernate.services;
import meli.bootcamp.hibernate.dtos.PatientDTO;
import meli.bootcamp.hibernate.entities.Patient;

import java.util.List;

public interface IPatientService {
    void savePatient(PatientDTO patient);
    PatientDTO getPatientById(Long id);
    void deletePatient(Long id);
    List<PatientDTO> getPatients();
    List<PatientDTO> findTodayPatients();
}
