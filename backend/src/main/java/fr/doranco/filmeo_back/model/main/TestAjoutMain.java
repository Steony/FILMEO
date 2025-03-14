/*package fr.doranco.filmeo_back.model.main;

import fr.doranco.filmeo_back.model.entity.Film;
import fr.doranco.filmeo_back.model.entity.Genre;
import fr.doranco.filmeo_back.model.entity.Nationalite;
import fr.doranco.filmeo_back.model.service.FilmService;
import fr.doranco.filmeo_back.model.service.GenreService;
import fr.doranco.filmeo_back.model.service.NationaliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "fr.doranco.filmeo_back")
@EntityScan(basePackages = "fr.doranco.filmeo_back.model.entity")
public class TestAjoutMain implements CommandLineRunner {

    @Autowired
    private GenreService genreService;

    @Autowired
    private NationaliteService nationaliteService;

    @Autowired
    private FilmService filmService;

    public static void main(String[] args) {
        SpringApplication.run(TestAjoutMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Créer des genres
        Genre action = new Genre();
        action.setLibelle("Action");
        genreService.addGenre(action);

        Genre comedie = new Genre();
        comedie.setLibelle("Comédie");
        genreService.addGenre(comedie);

        // Créer des nationalités
        Nationalite france = new Nationalite();
        france.setPays("France");
        nationaliteService.addNationalite(france);

        Nationalite usa = new Nationalite();
        usa.setPays("USA");
        nationaliteService.addNationalite(usa);

        // Créer un film avec des personnes (réalisateurs/acteurs)
        List<Long> personneIds = new ArrayList<>();
        // Ajouter les IDs des personnes (réalisateurs/acteurs) à cette liste, par exemple :
        // personneIds.add(1L);
        // personneIds.add(2L);

        Film film1 = new Film();
        film1.setTitre("Mission Impossible");
        film1.setDuree(120);
        film1.setDateSortie(new Date());
        film1.setGenre(action);  // Assurez-vous que vous récupérez le genre correctement
        filmService.addFilm(film1, france.getId(), personneIds);  // Utilisation de la méthode addFilm

        Film film2 = new Film();
        film2.setTitre("The Hangover");
        film2.setDuree(90);
        film2.setDateSortie(new Date());
        film2.setGenre(comedie);  // Assurez-vous que vous récupérez le genre correctement
        filmService.addFilm(film2, usa.getId(), personneIds);  // Utilisation de la méthode addFilm

        System.out.println("Films, genres et nationalités insérés !");
    }
}

*/