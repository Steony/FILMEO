package fr.doranco.filmeo_back.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data 
@Table(name = "evaluation")
public class Evaluation {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
     @Min(0) @Max(10)
    private Integer note;

    @Column(nullable = false)
    private String commentaire;

    @Column(nullable = false)
    private Date dateCommentaire;

    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", nullable = false) 
private User user;


    // Relation Many-to-One avec Film
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id") 
    private Film film;

    // Relation Many-to-One avec Serie
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id") 
    private Serie serie;

    // Relation Many-to-One avec Personne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id") // La clé étrangère 
    private Personne personne;
}
