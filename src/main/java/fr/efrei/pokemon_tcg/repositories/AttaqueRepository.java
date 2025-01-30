package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.efrei.pokemon_tcg.models.Attaque;

public interface AttaqueRepository extends JpaRepository<Attaque, String> {
}