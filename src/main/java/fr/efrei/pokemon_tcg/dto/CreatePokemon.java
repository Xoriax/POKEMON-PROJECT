package fr.efrei.pokemon_tcg.dto;

import org.hibernate.validator.constraints.Length;

import fr.efrei.pokemon_tcg.constants.TypePokemon;

public class CreatePokemon {

    @Length(min = 3, max = 20)
    private String nom;

    private TypePokemon type;

    private String attack1;

    private String attack2;

    public String getNom() {
        return nom;
    }

    public TypePokemon getType() {
        return type;
    }

    public String getAttack1() {
        return attack1;
    }

    public String getAttack2() {
        return attack2;
    }

}
