package org.example.hogwarts.repository;

import org.example.hogwarts.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT DISTINCT e FROM Estudiante e " +
            "LEFT JOIN FETCH e.casa " +
            "LEFT JOIN FETCH e.mascota " +
            "LEFT JOIN FETCH e.asignaturas")
    List<Estudiante> findAllCompleto();

    @Query("SELECT DISTINCT e FROM Estudiante e " +
            "LEFT JOIN FETCH e.asignaturas " +
            "LEFT JOIN FETCH e.mascota " +
            "WHERE e.id = :id")
    Optional<Estudiante> findByIdConTodo(@Param("id") Long id);
}