package org.example.hogwarts.controller;

import org.example.hogwarts.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsignaturaControlador.class)
public class AsignaturaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsignaturaService asignaturaService;

    @Test
    public void testEliminarAsignaturaConEstudiantes() throws Exception {
        Long asignaturaId = 1L;

        doThrow(new DataIntegrityViolationException("No se puede eliminar una asignatura con estudiantes asignados."))
                .when(asignaturaService).eliminarAsignatura(asignaturaId);

        mockMvc.perform(delete("/api/asignaturas/{id}", asignaturaId))
                .andExpect(status().isConflict());
    }
}
