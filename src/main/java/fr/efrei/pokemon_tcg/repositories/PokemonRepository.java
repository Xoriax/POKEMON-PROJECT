package fr.efrei.pokemon_tcg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, String> {

	// SELECT * FROM pokemon WHERE type_pokemon = :type;
	List<Pokemon> findAllByType(TypePokemon type);
}
