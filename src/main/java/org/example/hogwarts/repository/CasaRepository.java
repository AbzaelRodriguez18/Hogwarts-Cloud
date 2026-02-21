package org.example.hogwarts.repository;

import org.example.hogwarts.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long> {
    @Query("SELECT DISTINCT c FROM Casa c " +
            "LEFT JOIN FETCH c.jefe")
    List<Casa> findAllCompleto();
}