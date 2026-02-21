package org.example.hogwarts.service;

import org.example.hogwarts.model.DTOS.MascotaDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mappers.MascotaMapper;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository repositorio;
    @Autowired
    private MascotaMapper mapper;

    public List<MascotaDTO> obtenerTodas() {
        List<Mascota> mascotas = repositorio.findAllCompleto();
        List<MascotaDTO> dtos = new ArrayList<>();

        for (int i = 0; i < mascotas.size(); i++) {
            dtos.add(mapper.toDto(mascotas.get(i)));
        }
        return dtos;
    }
    @Transactional
    public void eliminarMascota(Long id) {
        Mascota m = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Mascota no encontrada con id: " + id));
        repositorio.delete(m);

    }
}