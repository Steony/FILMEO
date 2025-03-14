package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationaliteRepository extends JpaRepository<Nationalite, Long> {
}
