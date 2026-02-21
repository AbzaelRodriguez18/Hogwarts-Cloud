package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.model.DTOS.ProfesorDTO;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.model.Profesor;
import org.example.hogwarts.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorControlador {

    @Autowired
    private ProfesorService profesorService;

    @Operation(summary = "Obtine Todos los profesores")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Profesores encontrados exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Profesor.class))
            )
    })
    @GetMapping
    public List<ProfesorDTO> listarTodos() {
        return profesorService.obtenerTodos();
    }
}