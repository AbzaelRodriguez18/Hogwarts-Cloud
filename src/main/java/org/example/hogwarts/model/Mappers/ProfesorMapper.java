package org.example.hogwarts.model.Mappers;

import org.example.hogwarts.model.DTOS.ProfesorDTO;
import org.example.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO toDto(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre() + " " + profesor.getApellido());
        dto.setFechaInicio(profesor.getFechaInicio());
        dto.setAsignatura(profesor.getAsignatura().getNombre());
        return dto;
    }
}