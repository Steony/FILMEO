package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByLibelle(String libelle);
}
