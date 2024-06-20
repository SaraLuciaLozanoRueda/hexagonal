package com.hexagonal.Persona.domain.models;

public class Persona {
    int id_persona;
    int id_equipo;
    String nombre_persona;
    String apellido_persona;
    int edad_persona;
    int id_ciudad;

    public Persona() {
    }

    public Persona(int id_persona, int id_equipo, String nombre_persona, String apellido_persona, int edad_persona,
        int id_ciudad) {
        this.id_persona = id_persona;
        this.id_equipo = id_equipo;
        this.nombre_persona = nombre_persona;
        this.apellido_persona = apellido_persona;
        this.edad_persona = edad_persona;
        this.id_ciudad = id_ciudad;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        this.apellido_persona = apellido_persona;
    }

    public int getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(int edad_persona) {
        this.edad_persona = edad_persona;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    
    
}
