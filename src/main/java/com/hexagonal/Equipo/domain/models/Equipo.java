package com.hexagonal.Equipo.domain.models;

public class Equipo {
    int id_equipo;
    int id_partido;
    String nombre_equipo;
    int p_jugados;
    int p_ganados;
    int p_perdidos;
    int p_empates;
    int g_favor;
    int g_contra;
    int t_puntos;

    public Equipo() {
    }

    public Equipo(int id_equipo, int id_partido, String nombre_equipo, int p_jugados, int p_ganados, int p_perdidos,
            int p_empates, int g_favor, int g_contra, int t_puntos) {
        this.id_equipo = id_equipo;
        this.id_partido = id_partido;
        this.nombre_equipo = nombre_equipo;
        this.p_jugados = p_jugados;
        this.p_ganados = p_ganados;
        this.p_perdidos = p_perdidos;
        this.p_empates = p_empates;
        this.g_favor = g_favor;
        this.g_contra = g_contra;
        this.t_puntos = t_puntos;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public int getP_jugados() {
        return p_jugados;
    }

    public void setP_jugados(int p_jugados) {
        this.p_jugados = p_jugados;
    }

    public int getP_ganados() {
        return p_ganados;
    }

    public void setP_ganados(int p_ganados) {
        this.p_ganados = p_ganados;
    }

    public int getP_perdidos() {
        return p_perdidos;
    }

    public void setP_perdidos(int p_perdidos) {
        this.p_perdidos = p_perdidos;
    }

    public int getP_empates() {
        return p_empates;
    }

    public void setP_empates(int p_empates) {
        this.p_empates = p_empates;
    }

    public int getG_favor() {
        return g_favor;
    }

    public void setG_favor(int g_favor) {
        this.g_favor = g_favor;
    }

    public int getG_contra() {
        return g_contra;
    }

    public void setG_contra(int g_contra) {
        this.g_contra = g_contra;
    }

    public int getT_puntos() {
        return t_puntos;
    }

    public void setT_puntos(int t_puntos) {
        this.t_puntos = t_puntos;
    }

    
}
