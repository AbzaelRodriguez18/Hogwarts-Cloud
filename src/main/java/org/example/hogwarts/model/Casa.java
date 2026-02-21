package org.example.hogwarts.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private long id;

    private String nombre;
    private String fundador;
    private String fantasma;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    private Profesor jefe;


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFundador() { return fundador; }
    public void setFundador(String fundador) { this.fundador = fundador; }
    public String getFantasma() { return fantasma; }
    public void setFantasma(String fantasma) { this.fantasma = fantasma; }
    public Profesor getJefe() { return jefe; }
    public void setJefe(Profesor jefe) { this.jefe = jefe; }
}