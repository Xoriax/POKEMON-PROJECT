package fr.efrei.pokemon_tcg.services.implementations;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Tirage;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.repositories.TirageRepository;
import fr.efrei.pokemon_tcg.services.ITirageService;

@Service
public class TirageService implements ITirageService {

    @Autowired
    private TirageRepository tirageRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Tirage> findAll() {
        return tirageRepository.findAll();
    }

    @Override
    public Tirage findById(String uuid) {
        return tirageRepository.findById(uuid).orElse(null);
    }

    @Override
    public boolean create() {
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        List<Tirage> tiragesToday = tirageRepository.findTiragesByDate(startOfDay, endOfDay);

        if (tiragesToday.size() >= 5) {
            return false; // Limite de 5 tirages par jour atteinte
        }

        List<Card> cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            return false; // Pas de cartes disponibles
        }

        Random random = new Random();
        int tiragesToCreate = Math.min(5 - tiragesToday.size(), 5);

        for (int i = 0; i < tiragesToCreate; i++) {
            Card randomCard = cards.get(random.nextInt(cards.size()));

            Tirage tirage = new Tirage();
            tirage.setCard(randomCard);
            tirage.setDatedropped(LocalDateTime.now());
            tirageRepository.save(tirage);
        }

        return true;
    }

    @Override
    public boolean delete(String uuid) {
        if (tirageRepository.existsById(uuid)) {
            tirageRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}