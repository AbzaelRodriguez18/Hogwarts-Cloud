package org.example.hogwarts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudiante_Asignatura")
public class EstudianteAsignatura {

    @EmbeddedId
    ClaveCompuesta id;

    @ManyToOne
    @MapsId("estudianteID")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("asignaturaID")
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    @Column(name = "calificacion")
    private Double calificacion;


    public ClaveCompuesta getId() {
        return id;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
