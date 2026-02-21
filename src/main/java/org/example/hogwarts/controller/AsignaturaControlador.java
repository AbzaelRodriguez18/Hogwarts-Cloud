package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.DTOS.AsignaturaDTO;
import org.example.hogwarts.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaControlador{
    @Autowired
    private AsignaturaService asignaturaService;


    @Operation(summary = "Obtine Todos las asignaturas")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuarios encontrados exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Asignatura.class))
            )
    })
    @GetMapping
    public List<AsignaturaDTO> listarAsignaturas() {
        return asignaturaService.obtenerTodas();
    }

    @Operation(summary = "Elimina una asignatura existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuarios encontrados exitosamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Asignatura no encontrada con ese id",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "No se puede eliminar una asignatura con estudiantes asignados.",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignatura(@PathVariable Long id) {
        try {
            asignaturaService.eliminarAsignatura(id);
            return ResponseEntity.noContent().build();

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar una asignatura con estudiantes asignados.");

        }
    }
}