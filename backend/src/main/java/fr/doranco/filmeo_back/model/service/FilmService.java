package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.entity.Nationalite;
import fr.doranco.filmeo_back.model.entity.Personne;
import fr.doranco.filmeo_back.model.entity.Plateforme;
import fr.doranco.filmeo_back.model.repository.IFilmRepository;
import fr.doranco.filmeo_back.model.repository.IGenreRepository;
import fr.doranco.filmeo_back.model.repository.INationaliteRepository;
import fr.doranco.filmeo_back.model.repository.IPersonneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final IFilmRepository filmRepository;
    private final IGenreRepository genreRepository;
    private final INationaliteRepository nationaliteRepository;  // Nouveau
    private final IPersonneRepository personneRepository;  // Nouveau

    @Autowired
    public FilmService(IFilmRepository filmRepository, IGenreRepository genreRepository, 
                       INationaliteRepository nationaliteRepository, IPersonneRepository personneRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.nationaliteRepository = nationaliteRepository;
        this.personneRepository = personneRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public List<Film> getFilmsByTitle(String titre) {
        return filmRepository.findByTitreContainingIgnoreCase(titre);
    }

   public List<Film> getFilmsByGenre(String libelle) {
    Optional<Genre> genreOpt = genreRepository.findByLibelle(libelle);
    if (genreOpt.isPresent()) {
        return filmRepository.findByGenre(genreOpt.get());
    } else {
        // Si le genre n'existe pas, renvoyer une liste vide ou gérer autrement
        return new ArrayList<>();
    }
}


    // Méthode pour ajouter un film avec une nationalité et des personnes (réalisateurs/acteurs)
    public Film addFilm(Film film, Long nationaliteId, List<Long> personneIds) {
        Nationalite nationalite = nationaliteRepository.findById(nationaliteId)
            .orElseThrow(() -> new RuntimeException("Nationalité not found"));
        film.setNationalite(nationalite);

        List<Personne> personnes = personneRepository.findAllById(personneIds);
        film.setPersonnes(personnes);

        return filmRepository.save(film);
    }

    public Film updateFilm(Long id, Film filmDetails) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film not found"));
        film.setTitre(filmDetails.getTitre());
        film.setDuree(filmDetails.getDuree());
        film.setDateSortie(filmDetails.getDateSortie());
        film.setGenre(filmDetails.getGenre());

        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film not found"));
        filmRepository.delete(film);
    }

    public List<Plateforme> getPlateformesForFilm(Long filmId) {
    Film film = filmRepository.findById(filmId).orElseThrow(() -> new RuntimeException("Film not found"));
    return film.getPlateformes(); // Retourne la liste des plateformes associées
}

}
