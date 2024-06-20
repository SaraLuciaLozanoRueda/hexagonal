package com.hexagonal.Tecnico.domain.models;
import com.hexagonal.Persona.domain.models.Persona;

public class Tecnico extends Persona{
    int id_tecnico;
    int anyos_experiencia;
    String rol;

    public Tecnico (){

    }

    public Tecnico(int id_persona, int id_equipo, String nombre_persona, String apellido_persona, int edad_persona,
            int id_ciudad, int id_tecnico, int anyos_experiencia, String rol) {
        super(id_persona, id_equipo, nombre_persona, apellido_persona, edad_persona, id_ciudad);
        this.id_tecnico = id_tecnico;
        this.anyos_experiencia = anyos_experiencia;
        this.rol = rol;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getAnyos_experiencia() {
        return anyos_experiencia;
    }

    public void setAnyos_experiencia(int anyos_experiencia) {
        this.anyos_experiencia = anyos_experiencia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}
