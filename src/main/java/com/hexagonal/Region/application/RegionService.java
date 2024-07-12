package com.hexagonal.Region.application;

import java.util.List;
import java.util.Optional;

import com.hexagonal.Region.domain.models.Region;
import com.hexagonal.Region.infrastructure.RegionRepository;

public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void createRegion(Region region){
        regionRepository.save(region);
    }

    public void updateRegion(Region region){
        regionRepository.update(region);
    }

    public Optional<Region> findRegion(int id_region){
        return regionRepository.findById(id_region);
    }

    public void deleteRegion(int id_region){
        regionRepository.delete(id_region);
    }

    public List<Region> allRegiones(){
        return regionRepository.findAll();
    }
}
