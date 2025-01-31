package fr.efrei.pokemon_tcg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.models.Tirage;
import fr.efrei.pokemon_tcg.services.ITirageService;

@RestController
@RequestMapping("/tirages")
public class TirageController {

    @Autowired
    private ITirageService tirageService;

    @GetMapping
    public ResponseEntity<List<Tirage>> getAll() {
        return new ResponseEntity<>(tirageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Tirage> getById(@PathVariable String uuid) {
        Tirage tirage = tirageService.findById(uuid);
        if (tirage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tirage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create() {
        boolean created = tirageService.create();
        if (!created) {
            return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS); // Limite de tirages atteinte
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable String uuid) {
        boolean deleted = tirageService.delete(uuid);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}