package fr.efrei.pokemon_tcg.models;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
    // uuid de la carte
    // uuid du pokemon (selectionne aleatoirement le pokemon parmit ceux disponible
    // dans la DB)
    // PV qui doit etre ajouter et generer automatiquement lors de la creation
    // rarete qui dois etre aleatoire et attribue une rarete à la carte creer en
    // fonction du pourcentage des rareter
    // uuid de l'attaque pour le first_attaque
    // uuid de l'attaque pour le second_attaque

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "pokemon_uuid")
    private Pokemon pokemon;

    private int pv;

    public Card() {
        this.pv = genererPvAleatoires();
    }

    private int genererPvAleatoires() {
        Random random = new Random();
        return 150 + random.nextInt(151);
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

}