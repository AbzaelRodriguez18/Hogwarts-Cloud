package org.example.hogwarts.model.Actualizar;

import org.example.hogwarts.model.Mascota;

import java.time.LocalDate;

public class EstudianteUpdateDTO {
    private String anyoCurso;
    private LocalDate fechaNacimiento;
    private Mascota mascota;



    public void setAnyoCurso(String anyoCurso) {
        this.anyoCurso = anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getAnyoCurso() {
        return anyoCurso;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
