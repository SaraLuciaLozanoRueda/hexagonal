package com.hexagonal.Medico.domain.models;
import com.hexagonal.Persona.domain.models.Persona;

public class Medico extends Persona {
    int id_medico;
    String cargo;
    String afilia_eps;

    public Medico(){

    }

    public Medico(int id_persona, int id_equipo, String nombre_persona, String apellido_persona, int edad_persona,
            int id_ciudad, int id_medico, String cargo, String afilia_eps) {
        super(id_persona, id_equipo, nombre_persona, apellido_persona, edad_persona, id_ciudad);
        this.id_medico = id_medico;
        this.cargo = cargo;
        this.afilia_eps = afilia_eps;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAfilia_eps() {
        return afilia_eps;
    }

    public void setAfilia_eps(String afilia_eps) {
        this.afilia_eps = afilia_eps;
    }

    
}
