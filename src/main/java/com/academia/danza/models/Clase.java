package com.academia.danza.models;

import javax.persistence.*;

@Entity
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private Profesor profesor;

    @OneToOne
    @JoinColumn(name = "tipo_estilo_id", referencedColumnName = "id")
    private TipoEstilo tipoEstilo;

    private String dia;

    private String hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public TipoEstilo getTipoEstilo() {
        return tipoEstilo;
    }

    public void setTipoEstilo(TipoEstilo tipoEstilo) {
        this.tipoEstilo = tipoEstilo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
