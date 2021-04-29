package meli.bootcamp.hibernate.services;


import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.hibernate.dtos.DentistDto;
import meli.bootcamp.hibernate.entities.Dentist;
import meli.bootcamp.hibernate.repositories.IDentistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DentistService implements IDentistService{

    private IDentistRepository dentistRepository;

    public DentistService(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public void saveDentist(DentistDto dentist) {
        Dentist dentistMapped = new ObjectMapper().convertValue(dentist, Dentist.class);
        dentistRepository.save(dentistMapped);
    }

    @Override
    public DentistDto getDentistById(Long id) {
        Dentist dentistFound = dentistRepository.findById(id).orElse(null);
        DentistDto dentistMapped = new ObjectMapper().convertValue(dentistFound, DentistDto.class);
        return dentistMapped;
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public List<DentistDto> getDentists() {
        ObjectMapper mapper = new ObjectMapper();
        return dentistRepository.findAll().stream().map(d -> new ModelMapper().map(d, DentistDto.class)).collect(Collectors.toList());
    }


}
