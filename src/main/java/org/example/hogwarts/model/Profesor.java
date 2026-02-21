package org.example.hogwarts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

import java.time.LocalDate;

@Entity
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private long id;

    private String nombre;
    private String apellido;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }
}