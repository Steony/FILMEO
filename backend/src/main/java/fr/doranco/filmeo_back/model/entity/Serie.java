package fr.doranco.filmeo_back.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "series")

public class Serie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private Integer nombreSaison;

    @Column(nullable = false)
    private Integer nombreEpisode;

    //en cours ou terminée
    @Column(nullable = false)
    private String status;

     // Relation ManyToMany avec Personne
    @ManyToMany
    @JoinTable(
        name = "serie_personne",
        joinColumns = @JoinColumn(name = "serie_id"),
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
   name = "serie_plateforme", 
   joinColumns = @JoinColumn(name = "serie_id"), 
   inverseJoinColumns = @JoinColumn(name = "plateforme_id"))
 private List<Plateforme> plateformes;


 // relation OneToMany avec Evaluation
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;
}
