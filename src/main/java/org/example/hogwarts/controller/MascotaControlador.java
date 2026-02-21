package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.model.DTOS.MascotaDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaControlador {

    @Autowired
    private MascotaService mascotaService;

    @Operation(summary = "Obtine Todos las mascotas")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Mascotas encontradas exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
            )
    })
    @GetMapping
    public List<MascotaDTO> listarTodas() {
        return mascotaService.obtenerTodas();
    }
    @Operation(summary = "Elimina una mascota existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Mascota Eliminada Correctamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error Al eliminar a la mascota",
                    content = @Content
            )

    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }
}