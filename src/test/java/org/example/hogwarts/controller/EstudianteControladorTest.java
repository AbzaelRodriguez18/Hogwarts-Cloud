package org.example.hogwarts.controller;

import jakarta.transaction.Transactional;
import org.example.hogwarts.model.CrearDTO.EstudianteCreateDTO;
import org.example.hogwarts.model.CrearDTO.MascotaCreateDTO;
import org.example.hogwarts.model.DTOS.EstudianteDTO;
import org.example.hogwarts.repository.AsignaturaRepository;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EstudianteControladorTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EstudianteRepository EstudianteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private EstudianteCreateDTO estudianteCreateDTO;
    private EstudianteDTO EstudianteRespuestaDTO;



    @BeforeEach
    void setUp(){
        estudianteCreateDTO = new EstudianteCreateDTO();
        estudianteCreateDTO.setNombre("Abzael");
        estudianteCreateDTO.setApellido("Rodriguez");
        estudianteCreateDTO.setAnyoCurso(5L);
        estudianteCreateDTO.setCasaId(1L);


        MascotaCreateDTO mascota = new MascotaCreateDTO();
        mascota.setEspecie("Pastor Aleman");
        mascota.setNombre("Kratos");

        estudianteCreateDTO.setMascota(mascota);

        EstudianteRespuestaDTO = new EstudianteDTO();

        EstudianteRespuestaDTO.setId(1L);
        EstudianteRespuestaDTO.setAsignaturas(new ArrayList<>());




    }
    @Test
    void IntentarCrearUsuarioError() throws Exception {
        mockMvc.perform(post("/api/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isBadRequest());
    }
}
