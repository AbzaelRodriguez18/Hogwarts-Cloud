package org.example.hogwarts.service;

import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.DTOS.CasaDTO;
import org.example.hogwarts.model.Mappers.CasaMapper;
import org.example.hogwarts.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasaService {
    @Autowired
    private CasaRepository casaRepository;

    @Autowired
    private CasaMapper casaMapper;

    public List<CasaDTO> obtenerTodas() {
        List<Casa> casas = casaRepository.findAllCompleto();
        List<CasaDTO> dtos = new ArrayList<>();

        for (int i = 0; i < casas.size(); i++) {
            dtos.add(casaMapper.toDto(casas.get(i)));
        }
        return dtos;
    }
}
