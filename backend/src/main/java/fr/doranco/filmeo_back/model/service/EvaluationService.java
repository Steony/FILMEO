package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.*;
import fr.doranco.filmeo_back.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final IEvaluationRepository evaluationRepository;
    private final IFilmRepository filmRepository;
    private final ISerieRepository serieRepository;
    private final IPersonneRepository personneRepository;
    private final IUserRepository userRepository; // Ajout du UserRepository

    @Autowired
    public EvaluationService(
        IEvaluationRepository evaluationRepository, 
        IFilmRepository filmRepository, 
        ISerieRepository serieRepository, 
        IPersonneRepository personneRepository,
        IUserRepository userRepository) {
        
        this.evaluationRepository = evaluationRepository;
        this.filmRepository = filmRepository;
        this.serieRepository = serieRepository;
        this.personneRepository = personneRepository;
        this.userRepository = userRepository;
    }

    // Ajouter une évaluation pour un film
    public Evaluation addEvaluationForFilm(Long userId, Long filmId, Evaluation evaluation) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Film film = filmRepository.findById(filmId)
            .orElseThrow(() -> new RuntimeException("Film non trouvé"));

        evaluation.setUser(user);
        evaluation.setFilm(film);
        return evaluationRepository.save(evaluation);
    }

    // Ajouter une évaluation pour une série
    public Evaluation addEvaluationForSerie(Long userId, Long serieId, Evaluation evaluation) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Serie serie = serieRepository.findById(serieId)
            .orElseThrow(() -> new RuntimeException("Série non trouvée"));

        evaluation.setUser(user);
        evaluation.setSerie(serie);
        return evaluationRepository.save(evaluation);
    }

    // Ajouter une évaluation pour une personne
    public Evaluation addEvaluationForPersonne(Long userId, Long personneId, Evaluation evaluation) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Personne personne = personneRepository.findById(personneId)
            .orElseThrow(() -> new RuntimeException("Personne non trouvée"));

        evaluation.setUser(user);
        evaluation.setPersonne(personne);
        return evaluationRepository.save(evaluation);
    }

    // Récupérer les évaluations d'un film
    public List<Evaluation> getEvaluationsByFilm(Long filmId) {
        Film film = filmRepository.findById(filmId)
            .orElseThrow(() -> new RuntimeException("Film non trouvé"));
        return evaluationRepository.findByFilm(film);
    }

    // Récupérer les évaluations d'une série
    public List<Evaluation> getEvaluationsBySerie(Long serieId) {
        Serie serie = serieRepository.findById(serieId)
            .orElseThrow(() -> new RuntimeException("Série non trouvée"));
        return evaluationRepository.findBySerie(serie);
    }

    // Récupérer les évaluations d'une personne
    public List<Evaluation> getEvaluationsByPersonne(Long personneId) {
        Personne personne = personneRepository.findById(personneId)
            .orElseThrow(() -> new RuntimeException("Personne non trouvée"));
        return evaluationRepository.findByPersonne(personne);
    }

    // Récupérer les évaluations d'un utilisateur
    public List<Evaluation> getEvaluationsByUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return evaluationRepository.findByUser(user);
    }
}
