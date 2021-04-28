package meli.bootcamp.hibernate.services;

import meli.bootcamp.hibernate.entities.Dentist;
import meli.bootcamp.hibernate.repositories.IDentistRepository;
import org.springframework.stereotype.Service;

@Service
public class DentistService implements IDentistService{

    private IDentistRepository dentistRepository;

    public DentistService(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public void saveDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public Dentist getDentistById(Long id) {
        return dentistRepository;
    }

    @Override
    public void deleteDentist(Long id) {

    }
}
