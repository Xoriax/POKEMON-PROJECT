package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String uuid;

    private String rareté;

    @JoinColumn(name="pokemon_uuid")
    private Pokemon pokemon;

    public String getUuid() {
		return uuid;
	}

    public void setUuid(String uuid) {
		this.uuid = uuid;
	}

    public String getRareté() {
        return rareté;
    }

    public void setRareté(String rareté) {
        this.rareté = rareté;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
