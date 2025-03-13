package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.addGenre(genre);
    }
}
