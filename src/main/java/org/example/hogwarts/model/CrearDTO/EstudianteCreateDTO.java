package org.example.hogwarts.model.CrearDTO;

import java.time.LocalDate;

public class EstudianteCreateDTO {
    private String nombre;
    private String apellido;
    private long anyoCurso;
    private LocalDate fechaNacimiento;
    private long casaId;
    private MascotaCreateDTO mascota;

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

    public long getCasaId() {
        return casaId;
    }

    public void setCasaId(long casaId) {
        this.casaId = casaId;
    }

    public MascotaCreateDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaCreateDTO mascota) {
        this.mascota = mascota;
    }
}
