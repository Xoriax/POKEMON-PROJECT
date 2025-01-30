package fr.efrei.pokemon_tcg.services;

import java.util.List;

import fr.efrei.pokemon_tcg.dto.CreateAttaque;
import fr.efrei.pokemon_tcg.models.Attaque;

public interface IAttaqueService {

    List<Attaque> findAll();

    Attaque findById(String uuid);

    void create(CreateAttaque attaque);

    boolean update(String uuid, Attaque attaque);

    boolean delete(String uuid);
}
