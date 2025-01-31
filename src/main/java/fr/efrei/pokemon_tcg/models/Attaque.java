package fr.efrei.pokemon_tcg.models;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attaque {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String nom;

    private final int degats;

    public Attaque() {
        this.degats = genererDegatsAleatoires();
    }

    private int genererDegatsAleatoires() {
        Random random = new Random();
        return 50 + random.nextInt(151);
    }

    public String getUuid() {
        return uuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegats() {
        return degats;
    }
}
