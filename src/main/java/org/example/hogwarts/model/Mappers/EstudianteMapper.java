package org.example.hogwarts.model.Mappers;

import org.example.hogwarts.model.EstudianteAsignatura;
import org.example.hogwarts.model.DTOS.AsignaturaCalificacionDTO;
import org.example.hogwarts.model.DTOS.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EstudianteMapper {

    public EstudianteDTO toDto(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre() + " " + estudiante.getApellido());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        if (estudiante.getCasa() != null) {
            dto.setCasa(estudiante.getCasa().getNombre());
        } else {
            dto.setCasa("Sin casa");
        }
        
        if (estudiante.getMascota() == null) {
            dto.setMascota("No tiene mascota");
        }
        else {
            dto.setMascota(estudiante.getMascota().getNombre());
        }

        List<AsignaturaCalificacionDTO> listaAsig = new ArrayList<>();
        if (estudiante.getAsignaturas() != null) {
            for (EstudianteAsignatura ea : estudiante.getAsignaturas()) {
                AsignaturaCalificacionDTO asigDto = new AsignaturaCalificacionDTO();
                asigDto.setAsignatura(ea.getAsignatura().getNombre());

                if  (ea.getCalificacion() != null){
                    asigDto.setCalificacion(ea.getCalificacion());
                }
                else {
                    asigDto.setCalificacion(0.0);
                }
                listaAsig.add(asigDto);
            }
        }
        dto.setAsignaturas(listaAsig);
        return dto;
    }
}
