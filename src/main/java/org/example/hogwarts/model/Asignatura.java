package org.example.hogwarts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private long id;

    private String nombre;
    private String aula;
    private Boolean obligatoria;

    @OneToOne(mappedBy = "asignatura")
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura")
    private List<EstudianteAsignatura> estudiantes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
    public Boolean getObligatoria() { return obligatoria; }
    public void setObligatoria(Boolean obligatoria) { this.obligatoria = obligatoria; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public List<EstudianteAsignatura> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<EstudianteAsignatura> estudiantes) { this.estudiantes = estudiantes; }
}
