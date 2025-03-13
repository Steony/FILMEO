package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.entity.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {
     List<Film> findByGenre(Genre genre);

     //Recherche tous les films dont le titre contient le texte entré, sans distinction de majuscules/minuscules.
     List<Film> findByTitreContainingIgnoreCase(String titre);
}