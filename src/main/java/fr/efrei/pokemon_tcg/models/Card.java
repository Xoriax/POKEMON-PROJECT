package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public String getUuid() {
        return uuid;
    }

}
