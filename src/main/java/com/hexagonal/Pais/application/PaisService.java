package com.hexagonal.Pais.application;

import java.util.List;
import java.util.Optional;

import com.hexagonal.Pais.domain.models.Pais;
import com.hexagonal.Pais.infrastrucure.PaisRepository;

public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public void createPais(Pais pais){
        paisRepository.save(pais);
    }

    public void updatePais(Pais pais){
        paisRepository.update(pais);
    }

    public Optional<Pais> getPaisById(int id_pais){
        return paisRepository.findById(id_pais);
    }

    public void deletePais(int id_pais){
        paisRepository.delete(id_pais);
    }

    public List<Pais> getAllPaises(){
        return paisRepository.findAll();
    }
}
