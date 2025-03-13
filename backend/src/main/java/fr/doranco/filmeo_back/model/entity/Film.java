package fr.doranco.filmeo_back.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private Integer duree; // Durée du film en minutes

    @Column(nullable = false)
    private Date dateSortie;

    // Relation ManyToMany avec Personne (réalisateurs, acteurs)
    @ManyToMany
    @JoinTable(
        name = "film_personne",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "personne_id")
    )
    private List<Personne> personnes;
    
    // Relation ManyToOne avec Genre
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

     // Relation ManyToOne avec Nationalite
     @ManyToOne
     @JoinColumn(name = "nationalite_id", nullable = false)
     private Nationalite nationalite;

     
    @ManyToMany
    @JoinTable(
      name = "film_plateforme", 
      joinColumns = @JoinColumn(name = "film_id"), 
      inverseJoinColumns = @JoinColumn(name = "plateforme_id"))
    private List<Plateforme> plateformes;

     // relation OneToMany avec Evaluation
     @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Evaluation> evaluations;
}
