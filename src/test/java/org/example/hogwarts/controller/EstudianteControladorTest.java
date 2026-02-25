package org.example.hogwarts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hogwarts.model.CrearDTO.EstudianteCreateDTO;
import org.example.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstudianteControlador.class)
public class EstudianteControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCrearEstudianteConAnyoCursoInvalido() throws Exception {
        EstudianteCreateDTO dto = new EstudianteCreateDTO();
        dto.setNombre("Harry");
        dto.setApellido("Potter");
        dto.setAnyoCurso(10L);
        dto.setFechaNacimiento(java.time.LocalDate.of(1980, 7, 31));
        dto.setCasaId(1L);

        when(estudianteService.crearEstudiante(any(EstudianteCreateDTO.class)))
                .thenThrow(new IllegalArgumentException("El año del curso debe estar entre 1 y 7"));

        mockMvc.perform(post("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}
