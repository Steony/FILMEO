package fr.doranco.filmeo_back.controller;

import fr.doranco.filmeo_back.model.entity.Plateforme; // Import de l'entité Plateforme
import fr.doranco.filmeo_back.model.entity.Serie;
import fr.doranco.filmeo_back.model.service.PlateformeService; // Import du service Plateforme
import fr.doranco.filmeo_back.model.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SerieController {

    private final SerieService serieService;
    private final PlateformeService plateformeService; // Ajout du service Plateforme

    @Autowired
    public SerieController(SerieService serieService, PlateformeService plateformeService) {
        this.serieService = serieService;
        this.plateformeService = plateformeService; // Injection du service Plateforme
    }

    // 📌 Afficher la page des séries
    @GetMapping("/series")
    public String seriesPage(Model model) {
        List<Serie> series = serieService.getAllSeries();
        List<Plateforme> plateformes = plateformeService.getAllPlateformes(); // Récupérer toutes les plateformes

        model.addAttribute("series", series);
        model.addAttribute("plateformes", plateformes); // Ajouter les plateformes
        return "_type/serie";  // Vue des séries (serie.html)
    }

    // 📌 Afficher les détails d'une série
    @GetMapping("/series/{id}")
    public String getSerieDetails(@PathVariable Long id, Model model) {
        Serie serie = serieService.getSerieById(id).orElseThrow(() -> new RuntimeException("Serie not found"));
        List<Plateforme> plateformes = serie.getPlateformes(); // Récupérer les plateformes associées à la série

        model.addAttribute("serie", serie);
        model.addAttribute("plateformes", plateformes); // Ajouter les plateformes dans le modèle
        return "_type/serie_detail";  // Vue serie_detail.html
    }
}
