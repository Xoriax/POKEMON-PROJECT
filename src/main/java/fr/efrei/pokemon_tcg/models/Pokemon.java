package fr.efrei.pokemon_tcg.models;

import java.util.Random;

import fr.efrei.pokemon_tcg.constants.TypePokemon;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String nom;

    @Enumerated(EnumType.STRING)
    private TypePokemon type;

    private String attack1;
    private String attack2;
    private int attack1Power;
    private int attack2Power;

    public Pokemon() {
        Random random = new Random();
        this.attack1Power = random.nextInt(200) + 1;
        this.attack2Power = random.nextInt(200) + 1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypePokemon getType() {
        return type;
    }

    public void setType(TypePokemon type) {
        this.type = type;
    }

    public String getAttack1() {
        return attack1;
    }

    public void setAttack1(String attack1) {
        this.attack1 = attack1;
    }

    public String getAttack2() {
        return attack2;
    }

    public void setAttack2(String attack2) {
        this.attack2 = attack2;
    }

    public int getAttack1Power() {
        return attack1Power;
    }

    public void setAttack1Power(int attack1Power) {
        this.attack1Power = attack1Power;
    }

    public int getAttack2Power() {
        return attack2Power;
    }

    public void setAttack2Power(int attack2Power) {
        this.attack2Power = attack2Power;
    }

    public String getUuid() {
        return uuid;
    }
}
