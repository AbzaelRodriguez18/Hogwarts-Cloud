package org.example.hogwarts.repository;

import org.example.hogwarts.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    @Query("SELECT DISTINCT m FROM Mascota m LEFT JOIN FETCH m.estudiante")
    List<Mascota> findAllCompleto();
}