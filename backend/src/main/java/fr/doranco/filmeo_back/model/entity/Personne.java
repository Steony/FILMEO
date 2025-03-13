package fr.doranco.filmeo_back.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

@Table(name = "personnes")
public class Personne {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    //homme ou femme
    @Column(nullable = false)
    private String genre;

//// déterminer si la personne est acteur, réalisateur, producteur.
    @Column(nullable = false)
    private String metier;

    @Column(nullable = false)
    private String dateNaissance;

    private String dateDeces;

     // Relation ManyToOne avec Nationalite
    @ManyToOne
    @JoinColumn(name = "nationalite_id", nullable = false)
    private Nationalite nationalite;

    // Relation ManyToMany avec Film (une personne peut être liée à plusieurs films)
    @ManyToMany(mappedBy = "personnes")
    private List<Film> films;

    // Relation ManyToMany avec Serie (une personne peut être liée à plusieurs séries)
    @ManyToMany(mappedBy = "personnes")
    private List<Serie> series;

      // relation OneToMany avec Evaluation
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;
}
