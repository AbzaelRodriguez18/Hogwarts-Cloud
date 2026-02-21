package org.example.hogwarts.model.Mappers;

import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.DTOS.AsignaturaDTO;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO toDto(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());
        dto.setProfesor(asignatura.getProfesor().getNombre() + " " + asignatura.getProfesor().getApellido());
        return dto;
    }
}