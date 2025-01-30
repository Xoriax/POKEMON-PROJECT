package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import java.util.Random;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    // Nom de la carte
    private String nom;

    // Pokémon associé à la carte (via l'UUID du Pokémon)
    @ManyToOne
    @JoinColumn(name = "pokemon_uuid", referencedColumnName = "uuid")
    private Pokemon pokemon;

    // Dégâts de l'attaque
    private int dgtAtk;

    // Rareté de la carte (via l'UUID de la rareté)
    private String rareteNom;

    // PV de la carte, générés aléatoirement
    private int pv;

    // Fonction pour assigner la rareté avec un pourcentage d'apparition
    private String assignRarete(String rareteNom) {
        Random random = new Random();
        double chance = random.nextDouble(); // Valeur aléatoire entre 0.0 et 1.0

        if (chance < 0.6) {
            return rareteNom + " 1*"; // 60% chance de rareté 1*
        } else if (chance < 0.85) {
            return rareteNom + " 2*"; // 25% chance de rareté 2*
        } else {
            return rareteNom + " 3*"; // 15% chance de rareté 3*
        }
    }

    // Getters et setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getRareteNom() {
        return rareteNom;
    }

    public void setRareteNom(String rareteNom) {
        this.rareteNom = rareteNom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
