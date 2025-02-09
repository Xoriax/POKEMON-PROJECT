package fr.efrei.pokemon_tcg.services;

import java.util.List;

import fr.efrei.pokemon_tcg.models.Card;

public interface ICardService {
    List<Card> findAll();

    Card findById(String uuid);

    void create();

    boolean update(String uuid, Card card);

    boolean delete(String uuid);
}