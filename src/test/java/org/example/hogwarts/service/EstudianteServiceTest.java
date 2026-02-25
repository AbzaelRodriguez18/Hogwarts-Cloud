package org.example.hogwarts.service;

import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    private Estudiante estudiante;

    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante();
        estudiante.setId(1L);
        estudiante.setNombre("Harry");
        estudiante.setApellido("Potter");
    }

    @Test
    public void testEliminarEstudiante() {
        Long estudianteId = 1L;
        when(estudianteRepository.findById(estudianteId)).thenReturn(Optional.of(estudiante));

        estudianteService.eliminarEstudiante(estudianteId);

        verify(estudianteRepository, times(1)).delete(estudiante);
    }
}
