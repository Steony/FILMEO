package fr.doranco.filmeo_back.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

@Table(name = "nationalites")

public class Nationalite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String pays;

      // Relation OneToMany avec Personne
    @OneToMany(mappedBy = "nationalite")
    private List<Personne> personnes;

    // Relation OneToMany avec Film
    @OneToMany(mappedBy = "nationalite")
    private List<Film> films;

    // Relation OneToMany avec Serie
    @OneToMany(mappedBy = "nationalite")
    private List<Serie> series;
}
