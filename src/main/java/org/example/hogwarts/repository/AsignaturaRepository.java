package org.example.hogwarts.repository;

import org.example.hogwarts.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List; // <--- Cambiado de java.awt a java.util

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    @Query("SELECT DISTINCT a FROM Asignatura a " +
            "LEFT JOIN FETCH a.profesor")
    List<Asignatura> findAllCompleto();
}