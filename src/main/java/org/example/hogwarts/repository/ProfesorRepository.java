package org.example.hogwarts.repository;

import org.example.hogwarts.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
ProfesorRepository extends JpaRepository<Profesor, Long> {
    @Query("SELECT DISTINCT p FROM Profesor p " +
            "LEFT JOIN FETCH p.asignatura")
    List<Profesor> findAllCompleto();
}