package fr.efrei.pokemon_tcg.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.dto.CreateAttaque;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.repositories.AttaqueRepository;
import fr.efrei.pokemon_tcg.services.IAttaqueService;

@Service
public class AttaqueService implements IAttaqueService {

    @Autowired
    private AttaqueRepository attaqueRepository;

    @Override
    public List<Attaque> findAll() {
        return attaqueRepository.findAll();
    }

    @Override
    public Attaque findById(String uuid) {
        Optional<Attaque> attaque = attaqueRepository.findById(uuid);
        return attaque.orElse(null);
    }

    @Override
    public void create(CreateAttaque attaqueDto) {
        Attaque attaque = new Attaque();
        attaque.setNom(attaqueDto.getNom());
        attaqueRepository.save(attaque);
    }

    @Override
    public boolean update(String uuid, Attaque attaque) {
        Attaque attaqueAModifier = findById(uuid);
        if (attaqueAModifier == null) {
            return false;
        }
        attaqueAModifier.setNom(attaque.getNom());
        attaqueRepository.save(attaqueAModifier);
        return true;
    }

    @Override
    public boolean delete(String uuid) {
        if (attaqueRepository.existsById(uuid)) {
            attaqueRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
