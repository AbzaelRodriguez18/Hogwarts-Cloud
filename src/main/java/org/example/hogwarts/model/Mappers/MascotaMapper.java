package org.example.hogwarts.model.Mappers;

import org.example.hogwarts.model.DTOS.MascotaDTO;
import org.example.hogwarts.model.Mascota;
import org.springframework.stereotype.Component;


@Component
public class MascotaMapper {

    public MascotaDTO toDto(Mascota mascota) {
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiante(mascota.getEstudiante().getNombre() + " " + mascota.getEstudiante().getApellido());
        return dto;
    }
}