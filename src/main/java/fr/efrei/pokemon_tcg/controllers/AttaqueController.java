package fr.efrei.pokemon_tcg.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.CreateAttaque;
import fr.efrei.pokemon_tcg.models.Attaque;
import fr.efrei.pokemon_tcg.services.IAttaqueService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/attaques")
public class AttaqueController {

    private final IAttaqueService attaqueService;

    public AttaqueController(IAttaqueService attaqueService) {
        this.attaqueService = attaqueService;
    }

    @GetMapping
    public ResponseEntity<List<Attaque>> getAll(@RequestParam(required = false) String type) {
        return new ResponseEntity<>(attaqueService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Attaque> getById(@PathVariable String uuid) {
        Attaque attaque = attaqueService.findById(uuid);
        if (attaque != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attaqueService.findById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateAttaque createAttaque) {
        attaqueService.create(createAttaque);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> updateAttaque(@PathVariable String uuid, @RequestBody Attaque attaque) {
        boolean isModifier = attaqueService.update(uuid, attaque);
        if (!isModifier) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> updateAttaque(@PathVariable String uuid) {
        boolean isSupprimer = attaqueService.delete(uuid);
        if (!isSupprimer) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
