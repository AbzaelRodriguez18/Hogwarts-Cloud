package org.example.hogwarts.model.DTOS;

import java.util.List;

public class CasaDTO {
    private  long id;
    private  String nombre;
    private String fundador;
    private String fantasma;
    private  ProfesorDTO jefe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getFantasma() {
        return fantasma;
    }

    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }

    public ProfesorDTO getJefe() {
        return jefe;
    }

    public void setJefe(ProfesorDTO jefe) {
        this.jefe = jefe;
    }


}
