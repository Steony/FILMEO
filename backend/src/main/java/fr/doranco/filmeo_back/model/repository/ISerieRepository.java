package fr.doranco.filmeo_back.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.entity.Serie;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {
     List<Serie> findByGenre(Genre genre);

     //Recherche tous les films dont le titre contient le texte entré, sans distinction de majuscules/minuscules.
     List<Serie> findByTitreContainingIgnoreCase(String titre);
}
