package org.example.hogwarts.repository;

import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class EstudianteRepositoryTest {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Test
    public void testBorradoEnCascadaMascota() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Harry");
        estudiante.setApellido("Potter");
        estudiante.setAnyoCurso(1L);
        estudiante.setFechaNacimiento(java.time.LocalDate.of(1980, 7, 31));

        Mascota mascota = new Mascota();
        mascota.setNombre("Hedwig");
        mascota.setEspecie("Lechuza");
        mascota.setEstudiante(estudiante);
        estudiante.setMascota(mascota);

        estudianteRepository.save(estudiante);
        Long mascotaId = mascota.getId();

        estudianteRepository.delete(estudiante);

        Optional<Mascota> mascotaBorrada = mascotaRepository.findById(mascotaId);
        assertFalse(mascotaBorrada.isPresent(), "La mascota debería haber sido borrada junto con el estudiante");
    }
}
