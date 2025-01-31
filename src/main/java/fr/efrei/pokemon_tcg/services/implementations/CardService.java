package fr.efrei.pokemon_tcg.services.implementations;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.repositories.AttaqueRepository;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.repositories.PokemonRepository;
import fr.efrei.pokemon_tcg.services.ICardService;

@Service
public class CardService implements ICardService {

    private final CardRepository repository;
    private final PokemonRepository pokemonRepository;
    private final AttaqueRepository attaqueRepository;

    public CardService(CardRepository repository, PokemonRepository pokemonRepository, AttaqueRepository attaqueRepository) {
        this.repository = repository;
        this.pokemonRepository = pokemonRepository;
        this.attaqueRepository = attaqueRepository;
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public Card findById(String uuid) {
        return repository.findById(uuid).orElse(null);
    }

    @Override
    public void create() {
        Card card = new Card();
        List<Pokemon> pokemons = pokemonRepository.findAll();
        if (!pokemons.isEmpty()) {
            Random random = new Random();
            Pokemon randomPokemon = pokemons.get(random.nextInt(pokemons.size()));
            card.setPokemon(randomPokemon);
        }
        List<Attaque> attaques = attaqueRepository.findAll();
        if (!attaques.isEmpty()) {
            Random random = new Random();
            Attaque randomAttaque = attaques.get(random.nextInt(attaques.size()));
            card.setFirstAttaque(randomAttaque);
        }
        List<Attaque> attaques2 = attaqueRepository.findAll();
        if (!attaques2.isEmpty()) {
            Random random = new Random();
            Attaque randomAttaque = attaques2.get(random.nextInt(attaques2.size()));
            card.setSecondAttaque(randomAttaque);
        }
        repository.save(card);
    }

    @Override
    public boolean update(String uuid, Card card) {
        Card cardAModifier = findById(uuid);
        if (cardAModifier == null) {
            return false;
        }
        cardAModifier.setPokemon(card.getPokemon());
        cardAModifier.setRarity(card.getRarity());
        repository.save(cardAModifier);
        return true;
    }

    @Override
    public boolean delete(String uuid) {
        Card cardAModifier = findById(uuid);
        if (cardAModifier == null) {
            return false;
        }
        repository.deleteById(uuid);
        return true;
    }
}
