package fr.doranco.filmeo_back.model.repository;

import fr.doranco.filmeo_back.model.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Long> {
    
}
