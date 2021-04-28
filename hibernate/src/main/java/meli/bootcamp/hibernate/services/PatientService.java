package meli.bootcamp.hibernate.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.dtos.PatientDTO;
import meli.bootcamp.hibernate.entities.Patient;
import meli.bootcamp.hibernate.repositories.IPatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService{
    private final IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void savePatient(PatientDTO patientDTO) {
         Patient patient = new ObjectMapper().convertValue(patientDTO, Patient.class);
         patientRepository.save(patient);
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        PatientDTO patientDTO = new ObjectMapper().convertValue(patientRepository.findById(id), PatientDTO.class);
        return patientDTO;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> getPatients() {
        ObjectMapper mapper = new ObjectMapper();
        return patientRepository.findAll().stream().map(
                patient -> mapper.convertValue(patient, PatientDTO.class)
        ).collect(Collectors.toList());
    }
}