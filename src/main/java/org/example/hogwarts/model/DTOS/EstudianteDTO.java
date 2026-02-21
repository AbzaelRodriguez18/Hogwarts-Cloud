package org.example.hogwarts.model.DTOS;

import java.time.LocalDate;
import java.util.List;

public class EstudianteDTO {
    private long id;
    private String nombre;
    private long anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private String mascota;
    private List<AsignaturaCalificacionDTO> asignaturas;

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

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public List<AsignaturaCalificacionDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaCalificacionDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }
}