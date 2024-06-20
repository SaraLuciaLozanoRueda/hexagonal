package com.hexagonal.Ciudad.application;

import java.util.List;
import java.util.Optional;

import com.hexagonal.Ciudad.domain.models.Ciudad;
import com.hexagonal.Ciudad.infraestructure.CiudadRepository;

public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public void createCiudad(Ciudad ciudad){
        ciudadRepository.save(ciudad);
    }

    public void updateCiudad(Ciudad ciudad){
        ciudadRepository.update(ciudad);
    }

    public Optional<Ciudad> getCiudadById(int id_ciudad){
        return ciudadRepository.findById(id_ciudad);
    }

    public void deleteCiudad(int id_ciudad){
        ciudadRepository.delete(id_ciudad);
    }

    public List<Ciudad> getAllCiudades(){
        return ciudadRepository.findAll();
    }
}
