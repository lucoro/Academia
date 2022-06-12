package com.academia.danza.models;

import javax.persistence.*;
@Entity
@Table(name = "experiencia")
public class Experiencia {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @OneToOne
        @JoinColumn(name = "alumno_id", referencedColumnName = "id")
        private Alumno alumnoId;

        @OneToOne
        @JoinColumn(name = "tipo_estilo_id", referencedColumnName = "id")
        private TipoEstilo tipoEstiloId;
        private int years;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public TipoEstilo getTipoEstiloId() {
        return tipoEstiloId;
    }

    public void setTipoEstiloId(TipoEstilo tipoEstiloId) {
        this.tipoEstiloId = tipoEstiloId;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}

