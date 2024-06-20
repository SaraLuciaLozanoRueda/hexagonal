package com.hexagonal.Jugador.domain.models;
import com.hexagonal.Persona.domain.models.Persona;

public class Jugador extends Persona{
    int id_jugador;
    int rojas;
    int amarillas;
    int g_anotados;
    int numero_C;
    String posicion;

    public Jugador(){

    }

    public Jugador(int id_persona, int id_equipo, String nombre_persona, String apellido_persona, int edad_persona,
            int id_ciudad, int id_jugador, int rojas, int amarillas, int g_anotados, int numero_C, String posicion) {
        super(id_persona, id_equipo, nombre_persona, apellido_persona, edad_persona, id_ciudad);
        this.id_jugador = id_jugador;
        this.rojas = rojas;
        this.amarillas = amarillas;
        this.g_anotados = g_anotados;
        this.numero_C = numero_C;
        this.posicion = posicion;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public int getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getG_anotados() {
        return g_anotados;
    }

    public void setG_anotados(int g_anotados) {
        this.g_anotados = g_anotados;
    }

    public int getNumero_C() {
        return numero_C;
    }

    public void setNumero_C(int numero_C) {
        this.numero_C = numero_C;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    
}
