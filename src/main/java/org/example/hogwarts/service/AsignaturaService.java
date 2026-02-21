package org.example.hogwarts.service;

import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.DTOS.AsignaturaDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mappers.AsignaturaMapper;
import org.example.hogwarts.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturaService {
    @Autowired
    private AsignaturaRepository repositorio;
    @Autowired
    private AsignaturaMapper mapper;

    public List<AsignaturaDTO> obtenerTodas() {
        List<Asignatura> asignatura = repositorio.findAllCompleto();
        List<AsignaturaDTO> dtos = new ArrayList<>();

        for (int i = 0; i < asignatura.size(); i++) {
            dtos.add(mapper.toDto(asignatura.get(i)));
        }
        return dtos;
    }
    @Transactional
    public void eliminarAsignatura(Long id) {
        Asignatura a  = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Asignatura no encontrada con id :" + id));

        if (a.getProfesor() != null){
            a.getProfesor().setAsignatura(null);
        }
        repositorio.delete(a);

        repositorio.flush();
    }
}