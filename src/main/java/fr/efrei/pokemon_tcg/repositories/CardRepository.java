package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.efrei.pokemon_tcg.models.Card;

public interface CardRepository extends JpaRepository<Card, String> {
}