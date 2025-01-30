package fr.efrei.pokemon_tcg.services;

import java.util.List;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import fr.efrei.pokemon_tcg.dto.CreatePokemon;
import fr.efrei.pokemon_tcg.models.Pokemon;

public interface IPokemonService {

    List<Pokemon> findAll(TypePokemon type);

    Pokemon findById(String uuid);

    void create(CreatePokemon pokemon);

    boolean update(String uuid, Pokemon pokemon);

    boolean delete(String uuid);
}
