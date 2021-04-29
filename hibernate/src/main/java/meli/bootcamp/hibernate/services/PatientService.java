package meli.bootcamp.hibernate.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.dtos.AppointmentDto;
import meli.bootcamp.hibernate.dtos.PatientDTO;
import meli.bootcamp.hibernate.entities.Patient;
import meli.bootcamp.hibernate.repositories.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<PatientDTO> findTodayPatients() {
         DateTimeFormatter DATE_TIME_FORMATTER =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return patientRepository.findPatientByDate(LocalDate.now().format(DATE_TIME_FORMATTER)).stream()
                .map(p -> new ModelMapper().map(p, PatientDTO.class)).collect(Collectors.toList());
    }
}