package com.hexagonal.Pais.infrastrucure;

import java.util.List;
import java.util.Optional;
import com.hexagonal.Pais.domain.models.Pais;

public interface PaisRepository {
    void save(Pais pais);
    void update(Pais pais);
    Optional<Pais> findById(int id_pais);
    void delete(int id_pais);
    List<Pais> findAll();
}
