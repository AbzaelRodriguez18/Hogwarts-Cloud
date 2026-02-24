package org.example.hogwarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ClaveCompuesta implements Serializable {

    @Column(name = "id_estudiante")
    Long estudianteID;

    @Column(name = "id_asignatura")
    Long asignaturaID;
}
