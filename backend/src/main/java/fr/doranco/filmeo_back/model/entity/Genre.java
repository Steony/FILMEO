package fr.doranco.filmeo_back.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String libelle; // Nom du genre (Action, Comédie, Drame...)

    @OneToMany(mappedBy = "genre")
    private List<Film> films;
}
