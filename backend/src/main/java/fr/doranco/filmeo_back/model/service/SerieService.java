package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.entity.Nationalite;
import fr.doranco.filmeo_back.model.entity.Personne;
import fr.doranco.filmeo_back.model.entity.Plateforme;
import fr.doranco.filmeo_back.model.entity.Serie;
import fr.doranco.filmeo_back.model.repository.IGenreRepository;
import fr.doranco.filmeo_back.model.repository.INationaliteRepository;
import fr.doranco.filmeo_back.model.repository.IPersonneRepository;
import fr.doranco.filmeo_back.model.repository.ISerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final ISerieRepository serieRepository;
    private final IGenreRepository genreRepository;
    private final INationaliteRepository nationaliteRepository;  // Nouveau
    private final IPersonneRepository personneRepository;  // Nouveau

    @Autowired
    public SerieService(ISerieRepository serieRepository, IGenreRepository genreRepository, 
                        INationaliteRepository nationaliteRepository, IPersonneRepository personneRepository) {
        this.serieRepository = serieRepository;
        this.genreRepository = genreRepository;
        this.nationaliteRepository = nationaliteRepository;
        this.personneRepository = personneRepository;
    }

    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    public Optional<Serie> getSerieById(Long id) {
        return serieRepository.findById(id);
    }

    public List<Serie> getSeriesByTitle(String titre) {
        return serieRepository.findByTitreContainingIgnoreCase(titre);
    }

    public List<Serie> getSeriesByGenre(String libelle) {
        Genre genre = genreRepository.findByLibelle(libelle)
            .orElseThrow(() -> new RuntimeException("Genre not found"));
        return serieRepository.findByGenre(genre);
    }

    // Méthode pour ajouter une nouvelle série avec une nationalité et des personnes
    public Serie addSerie(Serie serie, Long nationaliteId, List<Long> personneIds) {
        Nationalite nationalite = nationaliteRepository.findById(nationaliteId)
            .orElseThrow(() -> new RuntimeException("Nationalité not found"));
        serie.setNationalite(nationalite);

        List<Personne> personnes = personneRepository.findAllById(personneIds);
        serie.setPersonnes(personnes);

        return serieRepository.save(serie);
    }

    public Serie updateSerie(Long id, Serie serieDetails) {
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Serie not found"));
        serie.setTitre(serieDetails.getTitre());
        serie.setNombreSaison(serieDetails.getNombreSaison());
        serie.setNombreEpisode(serieDetails.getNombreEpisode());
        serie.setStatus(serieDetails.getStatus());
        serie.setGenre(serieDetails.getGenre());

        return serieRepository.save(serie);
    }

    public void deleteSerie(Long id) {
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Serie not found"));
        serieRepository.delete(serie);
    }

    public List<Plateforme> getPlateformesForSerie(Long serieId) {
    Serie serie = serieRepository.findById(serieId).orElseThrow(() -> new RuntimeException("Serie not found"));
    return serie.getPlateformes(); // Retourne la liste des plateformes associées
}

}
