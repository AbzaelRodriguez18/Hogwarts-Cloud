package org.example.hogwarts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private long id;

    private String nombre;
    private String apellido;

    @Column(name = "anyo_curso")
    private long anyoCurso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @OneToOne(mappedBy = "estudiante")
    private Mascota mascota;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteAsignatura> asignaturas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getAnyoCurso() {
        return anyoCurso;
    }

    public void setAnyoCurso(long anyoCurso) {
        this.anyoCurso = anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<EstudianteAsignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<EstudianteAsignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
