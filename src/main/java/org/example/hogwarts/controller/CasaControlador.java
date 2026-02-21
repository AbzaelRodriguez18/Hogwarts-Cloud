package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.DTOS.CasaDTO;
import org.example.hogwarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
public class CasaControlador{
    @Autowired
    private CasaService casaService;


    @Operation(summary = "Obtine Todas las casas")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Casas encontradas exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Casa.class))
            )
    })
    @GetMapping
    public List<CasaDTO> listarCasas() {
        return casaService.obtenerTodas();
    }
}