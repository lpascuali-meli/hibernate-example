package meli.bootcamp.hibernate.services;

import meli.bootcamp.hibernate.dtos.DentistDto;
import meli.bootcamp.hibernate.entities.Dentist;

import java.util.List;
import java.util.Set;

public interface IDentistService {
    void saveDentist(DentistDto dentist);
    DentistDto getDentistById(Long id);
    void deleteDentist(Long id);
    List<DentistDto> getDentists();
}
