package org.example.hogwarts.model.Mappers;


import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.DTOS.CasaDTO;
import org.example.hogwarts.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CasaMapper {

    @Autowired
    private ProfesorMapper profesorMapper;

    public CasaDTO toDto(Casa casa) {
        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getId());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());
        dto.setJefe(profesorMapper.toDto(casa.getJefe()));
        return dto;
    }
}