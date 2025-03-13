package fr.doranco.filmeo_back.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name = "plateformes de visio")
public class Plateforme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String logo;

    @ManyToMany(mappedBy = "plateformes")
    private List<Film> films;

    @ManyToMany(mappedBy = "plateformes")
    private List<Serie> series;
    
}
