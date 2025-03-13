package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Nationalite;
import fr.doranco.filmeo_back.model.service.NationaliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nationalites")
public class NationaliteController {

    private final NationaliteService nationaliteService;

    @Autowired
    public NationaliteController(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }

    // Endpoint pour obtenir toutes les nationalités
    @GetMapping
    public List<Nationalite> getAllNationalites() {
        return nationaliteService.getAllNationalites();
    }

    // Endpoint pour obtenir une nationalité par son ID
    @GetMapping("/{id}")
    public Optional<Nationalite> getNationaliteById(@PathVariable Long id) {
        return nationaliteService.getNationaliteById(id);
    }

    // Endpoint pour ajouter une nouvelle nationalité
    @PostMapping
    public Nationalite addNationalite(@RequestBody Nationalite nationalite) {
        return nationaliteService.addNationalite(nationalite);
    }

    // Endpoint pour mettre à jour une nationalité existante
    @PutMapping("/{id}")
    public Nationalite updateNationalite(@PathVariable Long id, @RequestBody Nationalite nationaliteDetails) {
        return nationaliteService.updateNationalite(id, nationaliteDetails);
    }

    // Endpoint pour supprimer une nationalité
    @DeleteMapping("/{id}")
    public void deleteNationalite(@PathVariable Long id) {
        nationaliteService.deleteNationalite(id);
    }
}
