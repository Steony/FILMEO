package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Plateforme;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlateformeRepository extends JpaRepository<Plateforme, Long> {
    Optional<Plateforme> findByNom(String nom);

}
