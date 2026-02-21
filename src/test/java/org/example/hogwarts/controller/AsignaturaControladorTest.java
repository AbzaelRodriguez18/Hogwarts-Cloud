package org.example.hogwarts.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.CrearDTO.EstudianteCreateDTO;
import org.example.hogwarts.model.CrearDTO.MascotaCreateDTO;
import org.example.hogwarts.model.DTOS.AsignaturaDTO;
import org.example.hogwarts.model.DTOS.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Profesor;
import org.example.hogwarts.repository.AsignaturaRepository;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.service.AsignaturaService;
import org.example.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AsignaturaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EntityManager entityManager;

    private Asignatura asignatura;
    private Estudiante estudiante;




    @BeforeEach
    void setUp(){
        asignatura = new Asignatura();
        asignatura.setNombre("Quimica");
        asignatura.setAula("2");
        asignatura.setObligatoria(true);

        asignatura = asignaturaRepository.save(asignatura);

        estudiante = new Estudiante();
        estudiante.setNombre("Abzael");
        estudiante.setApellido("Rodriguez");
        estudiante.setAnyoCurso(6L);
        estudiante.setFechaNacimiento(LocalDate.now());

        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(asignatura);


        estudiante = estudianteRepository.save(estudiante);


        entityManager.flush();
        entityManager.clear();
    }
    @Test
    void IntentarEliminarAsignaturaError() throws Exception {
        mockMvc.perform(delete("/api/asignaturas/{id}", asignatura.getId())
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isConflict());
    }
}
