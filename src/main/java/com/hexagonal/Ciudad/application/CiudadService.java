package com.hexagonal.Ciudad.application;

import java.util.List;
import java.util.Optional;

import com.hexagonal.Ciudad.domain.models.Ciudad;
import com.hexagonal.Ciudad.infraestructure.CiudadRepository;
import com.hexagonal.Region.domain.models.Region;
import com.hexagonal.Region.infrastructure.RegionRepository;

public class CiudadService {
    private final CiudadRepository ciudadRepository;
    private final RegionRepository regionRepository;

    public CiudadService(CiudadRepository ciudadRepository,RegionRepository regionRepository) {
        this.ciudadRepository = ciudadRepository;
        this.regionRepository = regionRepository;
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

    //TRAER METODOS DE LA REGION
    public List<Region> allRegiones(){
        return regionRepository.findAll();
    }

    public Optional<Region>findRegion(int id_region){
        return regionRepository.findById(id_region);
    }
}
