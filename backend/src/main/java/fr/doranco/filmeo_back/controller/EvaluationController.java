package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Evaluation;
import fr.doranco.filmeo_back.model.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    // Ajouter une évaluation à un film
    @PostMapping("/film/{filmId}/user/{userId}")
    public Evaluation addEvaluationForFilm(@PathVariable Long userId, @PathVariable Long filmId, @RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluationForFilm(userId, filmId, evaluation);
    }

    // Ajouter une évaluation à une série
    @PostMapping("/serie/{serieId}/user/{userId}")
    public Evaluation addEvaluationForSerie(@PathVariable Long userId, @PathVariable Long serieId, @RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluationForSerie(userId, serieId, evaluation);
    }

    // Ajouter une évaluation à une personne
    @PostMapping("/personne/{personneId}/user/{userId}")
    public Evaluation addEvaluationForPersonne(@PathVariable Long userId, @PathVariable Long personneId, @RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluationForPersonne(userId, personneId, evaluation);
    }

    // Récupérer les évaluations d'un film
    @GetMapping("/film/{filmId}")
    public List<Evaluation> getEvaluationsByFilm(@PathVariable Long filmId) {
        return evaluationService.getEvaluationsByFilm(filmId);
    }

    // Récupérer les évaluations d'une série
    @GetMapping("/serie/{serieId}")
    public List<Evaluation> getEvaluationsBySerie(@PathVariable Long serieId) {
        return evaluationService.getEvaluationsBySerie(serieId);
    }

    // Récupérer les évaluations d'une personne
    @GetMapping("/personne/{personneId}")
    public List<Evaluation> getEvaluationsByPersonne(@PathVariable Long personneId) {
        return evaluationService.getEvaluationsByPersonne(personneId);
    }

    // Récupérer les évaluations d'un utilisateur
    @GetMapping("/user/{userId}")
    public List<Evaluation> getEvaluationsByUser(@PathVariable Long userId) {
        return evaluationService.getEvaluationsByUser(userId);
    }
}
