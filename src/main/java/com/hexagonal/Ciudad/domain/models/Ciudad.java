package com.hexagonal.Ciudad.domain.models;

public class Ciudad {
    int id_ciudad;
    String nombre_ciudad;
    int id_region;

    public Ciudad() {
    }

    public Ciudad(int id_ciudad, String nombre_ciudad, int id_region) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
        this.id_region = id_region;
    }

    
    public Ciudad(String nombre_ciudad, int id_region) {
        this.nombre_ciudad = nombre_ciudad;
        this.id_region = id_region;
    }

    public Ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public Ciudad(int id_region) {
        this.id_region = id_region;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    
    
}
