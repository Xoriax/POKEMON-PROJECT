package fr.efrei.pokemon_tcg.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.efrei.pokemon_tcg.models.Tirage;

public interface TirageRepository extends JpaRepository<Tirage, String> {

    @Query("SELECT t FROM Tirage t WHERE t.datedropped BETWEEN :startOfDay AND :endOfDay")
    List<Tirage> findTiragesByDate(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);
}