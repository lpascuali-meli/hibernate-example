package meli.bootcamp.hibernate.services;

import meli.bootcamp.hibernate.entities.Dentist;

public interface IDentistService {
    void saveDentist(Dentist dentist);
    Dentist getDentistById(Long id);

}
