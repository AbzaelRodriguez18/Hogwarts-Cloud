package org.example.hogwarts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_mascota")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "especie")
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estudiante estudiante;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
}