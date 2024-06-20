package com.hexagonal.Partido.domain.models;

public class Partido {
    int id_partido;
    int marc_local;
    int marc_visitante;
    String fecha;
    String e_visitante;
    String e_local;
    
    public Partido() {
    }

    public Partido(int id_partido, int marc_local, int marc_visitante, String fecha, String e_visitante,
            String e_local) {
        this.id_partido = id_partido;
        this.marc_local = marc_local;
        this.marc_visitante = marc_visitante;
        this.fecha = fecha;
        this.e_visitante = e_visitante;
        this.e_local = e_local;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getMarc_local() {
        return marc_local;
    }

    public void setMarc_local(int marc_local) {
        this.marc_local = marc_local;
    }

    public int getMarc_visitante() {
        return marc_visitante;
    }

    public void setMarc_visitante(int marc_visitante) {
        this.marc_visitante = marc_visitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getE_visitante() {
        return e_visitante;
    }

    public void setE_visitante(String e_visitante) {
        this.e_visitante = e_visitante;
    }

    public String getE_local() {
        return e_local;
    }

    public void setE_local(String e_local) {
        this.e_local = e_local;
    }

    
}
