package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.service.FilmService;
import fr.doranco.filmeo_back.model.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FilmController {

    private final FilmService filmService;
    private final GenreService genreService;

    @Autowired
    public FilmController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    @GetMapping("/films")
public String filmsPage(Model model) {
    try {
        List<Film> films = filmService.getAllFilms();  // Récupère les films depuis le service
        model.addAttribute("films", films);
        return "_type/film"; // Retourne la page des films
    } catch (Exception e) {
        model.addAttribute("error", "Une erreur s'est produite lors de la récupération des films.");
        return "error";  // Utilise une page d'erreur si une exception se produit
    }
}


    @GetMapping("/films/search")
    public String searchFilms(Model model) {
        List<Film> films = filmService.getAllFilms(); // Pas de logique de recherche
        model.addAttribute("films", films);
        model.addAttribute("genres", genreService.getAllGenres());
        return "_type/film"; // Retourne la page des films avec tous les films
    }
}
