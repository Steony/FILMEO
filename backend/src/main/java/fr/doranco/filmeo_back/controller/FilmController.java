package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.entity.Plateforme; // Import de l'entité Plateforme
import fr.doranco.filmeo_back.model.service.FilmService;
import fr.doranco.filmeo_back.model.service.GenreService;
import fr.doranco.filmeo_back.model.service.PlateformeService; // Import du service Plateforme
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FilmController {

    private final FilmService filmService;
    private final GenreService genreService;
    private final PlateformeService plateformeService;

    @Autowired
    public FilmController(FilmService filmService, GenreService genreService, PlateformeService plateformeService) {
        this.filmService = filmService;
        this.genreService = genreService;
        this.plateformeService = plateformeService; // Injection du service Plateforme
    }

    // 📌 Page principale des films avec menu déroulant des genres
    @GetMapping("/films")
    public String filmsPage(Model model) {
        List<Film> films = filmService.getAllFilms();
        List<Genre> genres = genreService.getAllGenres(); // Récupère tous les genres
        List<Plateforme> plateformes = plateformeService.getAllPlateformes(); // Récupère toutes les plateformes

        model.addAttribute("films", films);
        model.addAttribute("genres", genres);
        model.addAttribute("plateformes", plateformes); // Ajout des plateformes pour les films
        return "_type/film";
    }

    // 📌 Afficher les films par genre
    @GetMapping("/films/genre/{libelle}")
    public String filmsByGenre(@PathVariable String libelle, Model model) {
        List<Film> films = filmService.getFilmsByGenre(libelle);
        List<Genre> genres = genreService.getAllGenres(); // Toujours afficher les genres
        List<Plateforme> plateformes = plateformeService.getAllPlateformes(); // Récupère toutes les plateformes

        model.addAttribute("films", films);
        model.addAttribute("genres", genres);
        model.addAttribute("plateformes", plateformes); // Ajout des plateformes
        model.addAttribute("selectedGenre", libelle); // Option sélectionnée
        return "_type/film";
    }

    // 📌 Afficher les détails d'un film
    @GetMapping("/films/{id}")
    public String getFilmDetails(@PathVariable Long id, Model model) {
        Film film = filmService.getFilmById(id).orElseThrow(() -> new RuntimeException("Film not found"));
        List<Plateforme> plateformes = film.getPlateformes(); // Récupérer les plateformes associées au film

        model.addAttribute("film", film);
        model.addAttribute("plateformes", plateformes); // Ajouter les plateformes dans le modèle
        return "_type/film_detail";  // Vue film_detail.html
    }
}
