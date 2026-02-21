package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.model.Actualizar.EstudianteUpdateDTO;
import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.CrearDTO.EstudianteCreateDTO;
import org.example.hogwarts.model.DTOS.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteControlador {
    @Autowired
    private EstudianteService servicioEstudiante;

    @Operation(summary = "Obtine Todos los estudiantes")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiantes encontrados exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
            )
    })
    @GetMapping
    public List<EstudianteDTO> listarEstudiantes() {
        return servicioEstudiante.obtenerTodos();
    }




    @Operation(summary = "Obtine un estudiante por su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante encontrado exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Estudiante no encontrado con ese id",
                    content = @Content
            )

    })
    @GetMapping("/{id}")
    public EstudianteDTO listarEstudiante(@PathVariable("id") long id) {
        return servicioEstudiante.obtenerUno(id);
    }


    @Operation(summary = "Crea un nuevo Usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Estudiante Creado exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudianteCreateDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la creacion del estudiante",
                    content = @Content
            )

    })
    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteCreateDTO estudianteCreateDTO) {
        try {
            EstudianteDTO nuevoEstudiante = servicioEstudiante.crearEstudiante(estudianteCreateDTO);
            return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Actualizar un Usuario existente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante Actualizado Correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudianteUpdateDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la Actualizacion del estudiante",
                    content = @Content
            )

    })
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> ActualizarEstudiante(@PathVariable("id") long id, @RequestBody EstudianteUpdateDTO estudianteUpdateDTO) {
        try {
            EstudianteDTO EstudianteActualizado = servicioEstudiante.ActualizarEstudiante(id,estudianteUpdateDTO);
            return new ResponseEntity<>(EstudianteActualizado, HttpStatus.OK);


        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Eliminar un Usuario existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante Eliminado Correctamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error Al eliminar al estudiante",
                    content = @Content
            )

    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        servicioEstudiante.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
