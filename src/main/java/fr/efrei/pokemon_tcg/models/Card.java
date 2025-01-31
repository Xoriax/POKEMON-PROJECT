package fr.efrei.pokemon_tcg.models;

import java.util.Random;

import fr.efrei.pokemon_tcg.constants.Rarity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "pokemon_uuid")
    private Pokemon pokemon;

    private final int pv;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @ManyToOne
    @JoinColumn(name = "first_attaque_uuid")
    private Attaque firstAttaque;

    @ManyToOne
    @JoinColumn(name = "second_attaque_uuid")
    private Attaque secondAttaque;

    public Card() {
        this.pv = genererPvAleatoires();
        this.rarity = genererRarityAleatoire();
    }

    private int genererPvAleatoires() {
        Random random = new Random();
        return 150 + random.nextInt(151);
    }

    private Rarity genererRarityAleatoire() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        if (chance <= 50) {
            return Rarity.COMMON; 
        }else if (chance <= 80) {
            return Rarity.UNCOMMON; 
        }else if (chance <= 95) {
            return Rarity.RARE; 
        }else if (chance <= 99) {
            return Rarity.EPIC; 
        }else {
            return Rarity.LEGENDARY;
        }
    }

    public String getUuid() {
        return uuid;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getPv() {
        return pv;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Attaque getFirstAttaque() {
        return firstAttaque;
    }

    public void setFirstAttaque(Attaque firstAttaque) {
        this.firstAttaque = firstAttaque;
    }

    public Attaque getSecondAttaque() {
        return secondAttaque;
    }

    public void setSecondAttaque(Attaque secondAttaque) {
        this.secondAttaque = secondAttaque;
    }
}
