package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Evaluation;
import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.entity.Personne;
import fr.doranco.filmeo_back.model.entity.Serie;
import fr.doranco.filmeo_back.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findByFilm(Film film);
    List<Evaluation> findBySerie(Serie serie);
    List<Evaluation> findByPersonne(Personne personne);
    List<Evaluation> findByUser(User user);
}
