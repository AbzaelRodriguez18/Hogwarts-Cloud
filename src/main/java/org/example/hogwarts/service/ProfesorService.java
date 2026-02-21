package org.example.hogwarts.service;

import org.example.hogwarts.model.DTOS.ProfesorDTO;
import org.example.hogwarts.model.Mappers.ProfesorMapper;
import org.example.hogwarts.model.Profesor;
import org.example.hogwarts.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository repositorio;
    @Autowired
    private ProfesorMapper mapper;

    public List<ProfesorDTO> obtenerTodos() {
        List<Profesor> entidades = repositorio.findAllCompleto();
        List<ProfesorDTO> dtos = new ArrayList<>();

        for (int i = 0; i < entidades.size(); i++) {
            dtos.add(mapper.toDto(entidades.get(i)));
        }
        return dtos;
    }
}