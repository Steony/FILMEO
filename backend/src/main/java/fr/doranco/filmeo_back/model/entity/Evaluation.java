package fr.doranco.filmeo_back.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(0)
    @Max(10)
    private Integer note;

    @Column(nullable = false, length = 1000)
    private String commentaire;

    @Column(nullable = false)
    private Date dateCommentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relation Many-to-One avec Film
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")  // La clé étrangère qui référence Film
    private Film film;

    // Relation Many-to-One avec Serie ( évaluation pourrait être soit un film, soit une série)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    private Serie serie;

    // Relation Many-to-One avec Personne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id") // La clé étrangère
    private Personne personne;
}
