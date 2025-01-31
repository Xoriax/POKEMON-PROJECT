package fr.efrei.pokemon_tcg.dto;

public class CreateCard {

    private String pokemonUuid;

    public String getPokemonUuid() {
        return pokemonUuid;
    }

    public void setPokemonUuid(String pokemonUuid) {
        this.pokemonUuid = pokemonUuid;
    }
}