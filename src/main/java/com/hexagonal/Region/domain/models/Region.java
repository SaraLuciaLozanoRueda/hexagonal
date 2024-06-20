package com.hexagonal.Region.domain.models;

public class Region {
    int id_region;
    String nombre_region;
    int id_pais;

    public Region() {
    }

    public Region(int id_region, String nombre_region, int id_pais) {
        this.id_region = id_region;
        this.nombre_region = nombre_region;
        this.id_pais = id_pais;
    }

    
    public Region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    
    public Region(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    
    
    
}
