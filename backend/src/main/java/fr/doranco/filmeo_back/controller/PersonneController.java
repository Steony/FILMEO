package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Personne;
import fr.doranco.filmeo_back.model.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    // Endpoint pour obtenir toutes les personnes
    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    // Endpoint pour obtenir une personne par son ID
    @GetMapping("/{id}")
    public Optional<Personne> getPersonneById(@PathVariable Long id) {
        return personneService.getPersonneById(id);
    }

    // Endpoint pour ajouter une nouvelle personne
    @PostMapping
    public Personne addPersonne(@RequestBody Personne personne) {
        return personneService.addPersonne(personne);
    }

    // Endpoint pour mettre à jour une personne existante
    @PutMapping("/{id}")
    public Personne updatePersonne(@PathVariable Long id, @RequestBody Personne personneDetails) {
        return personneService.updatePersonne(id, personneDetails);
    }

    // Endpoint pour supprimer une personne
    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
    }
}
