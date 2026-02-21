package org.example.hogwarts.service;

import org.example.hogwarts.model.Actualizar.EstudianteUpdateDTO;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.CrearDTO.EstudianteCreateDTO;
import org.example.hogwarts.model.DTOS.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.model.Mappers.EstudianteMapper;
import org.example.hogwarts.repository.CasaRepository;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repositorio;
    @Autowired
    private CasaRepository casaRepository;
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private EstudianteMapper mapper;

    public List<EstudianteDTO> obtenerTodos() {
        List<Estudiante> entidades = repositorio.findAllCompleto();
        List<EstudianteDTO> dtos = new ArrayList<>();

        for (int i = 0; i < entidades.size(); i++) {
            dtos.add(mapper.toDto(entidades.get(i)));
        }
        return dtos;
    }

    public EstudianteDTO obtenerUno(long id) {
        Optional<Estudiante> estudiante1 = repositorio.findByIdConTodo(id);
        if (estudiante1.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Estudiante con ID " + id + " no existe");
        }
        return mapper.toDto(estudiante1.get());
    }


    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto) {
        if (dto.getNombre() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }
        if (dto.getApellido() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido es obligatorio");
        }
        if (dto.getFechaNacimiento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de nacimiento es obligatoria");
        }

        Optional<Casa> casaOpt = casaRepository.findById(dto.getCasaId());
        if (casaOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La casa con ID " + dto.getCasaId() + " no existe");
        }

        if (dto.getAnyoCurso() < 1 || dto.getAnyoCurso() > 7) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el anyo curso debe estar entre 1 y 7");
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setCasa(casaOpt.get());

        estudiante = repositorio.save(estudiante);

        if (dto.getMascota() != null) {
            if (dto.getMascota().getNombre() == null ) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de la mascota es obligatorio");
            }
            if (dto.getMascota().getEspecie() == null ) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La especie de la mascota es obligatoria");
            }

            Mascota mascota = new Mascota();
            mascota.setNombre(dto.getMascota().getNombre());
            mascota.setEspecie(dto.getMascota().getEspecie());
            mascota.setEstudiante(estudiante);
            mascota = mascotaRepository.save(mascota);
            estudiante.setMascota(mascota);
        }

        return mapper.toDto(estudiante);
    }

    @Transactional
    public EstudianteDTO ActualizarEstudiante(long id, EstudianteUpdateDTO DtoNuevaInfo) {
        Estudiante estudianteAntiguo = repositorio.findByIdConTodo(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ese estudiante"));

        if (DtoNuevaInfo.getAnyoCurso() != null){
            estudianteAntiguo.setAnyoCurso(Long.parseLong(DtoNuevaInfo.getAnyoCurso()));
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el Anyo curso es obligatoria");
        }

        if (DtoNuevaInfo.getFechaNacimiento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La fecha de nacimiento es obligatoria");
        }
        else {
            estudianteAntiguo.setFechaNacimiento(DtoNuevaInfo.getFechaNacimiento());
        }

        if (DtoNuevaInfo.getMascota() != null) {

            Mascota mascotaActual = estudianteAntiguo.getMascota();

            if (mascotaActual == null) {
                mascotaActual = new Mascota();
                mascotaActual.setEstudiante(estudianteAntiguo);
            }

            mascotaActual.setNombre(DtoNuevaInfo.getMascota().getNombre());
            mascotaActual.setEspecie(DtoNuevaInfo.getMascota().getEspecie());

            mascotaRepository.save(mascotaActual);

            estudianteAntiguo.setMascota(mascotaActual);
        }
        else {
            Mascota mascotaVieja = estudianteAntiguo.getMascota();

            if (mascotaVieja != null) {
                estudianteAntiguo.setMascota(null);

                mascotaRepository.delete(mascotaVieja);
            }
        }

        Estudiante estudianteGuardado = repositorio.save(estudianteAntiguo);

        return mapper.toDto(estudianteGuardado);
    }
    @Transactional
    public void eliminarEstudiante(Long id) {
         Estudiante e = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Estudiante no encontrado con id :" + id));

        repositorio.delete(e);

    }




}
