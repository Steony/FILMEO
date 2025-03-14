package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories(basePackages = "fr.doranco.filmeo_back.model.repository")
public interface IGenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByLibelle(String libelle);
}
