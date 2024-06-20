package com.hexagonal.Ciudad.infraestructure;

import java.util.List;
import java.util.Optional;
import com.hexagonal.Ciudad.domain.models.Ciudad;

public interface CiudadRepository {
    void save(Ciudad ciudad);
    void update(Ciudad ciudad);
    Optional<Ciudad> findById(int id_ciudad);
    void delete(int id_ciudad);
    List<Ciudad> findAll();
    
}
