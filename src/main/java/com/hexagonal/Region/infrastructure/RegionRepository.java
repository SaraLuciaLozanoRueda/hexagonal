package com.hexagonal.Region.infrastructure;

import java.util.List;
import java.util.Optional;

import com.hexagonal.Region.domain.models.Region;

public interface RegionRepository {
    void save(Region region);
    void update(Region region);
    Optional<Region> findById(int id_region);
    void delete(int id_region);
    List<Region> findAll();
}
