package fr.efrei.pokemon_tcg.services;

import java.util.List;

import fr.efrei.pokemon_tcg.models.Tirage;

public interface ITirageService {
    List<Tirage> findAll();
    Tirage findById(String uuid);
    boolean create();
    boolean delete(String uuid);
}