package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final IGenreRepository genreRepository;

    @Autowired
    public GenreService(IGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreByLibelle(String libelle) {
        return genreRepository.findByLibelle(libelle);
    }

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}
