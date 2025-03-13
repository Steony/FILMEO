package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Plateforme;
import fr.doranco.filmeo_back.model.repository.IPlateformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateformeService {

    private final IPlateformeRepository plateformeRepository;

    @Autowired
    public PlateformeService(IPlateformeRepository plateformeRepository) {
        this.plateformeRepository = plateformeRepository;
    }

    public List<Plateforme> getAllPlateformes() {
        return plateformeRepository.findAll();
    }

    public Plateforme getPlateformeById(Long id) {
        return plateformeRepository.findById(id).orElseThrow(() -> new RuntimeException("Plateforme not found"));
    }

    // Méthode pour ajouter une plateforme
    public Plateforme addPlateforme(Plateforme plateforme) {
        return plateformeRepository.save(plateforme);
    }

    // Méthode pour mettre à jour une plateforme
    public Plateforme updatePlateforme(Long id, Plateforme plateformeDetails) {
        Plateforme plateforme = plateformeRepository.findById(id).orElseThrow(() -> new RuntimeException("Plateforme not found"));
        plateforme.setNom(plateformeDetails.getNom());
        plateforme.setUrl(plateformeDetails.getUrl());
        plateforme.setLogo(plateformeDetails.getLogo());
        
        return plateformeRepository.save(plateforme);
    }

    // Méthode pour supprimer une plateforme
    public void deletePlateforme(Long id) {
        Plateforme plateforme = plateformeRepository.findById(id).orElseThrow(() -> new RuntimeException("Plateforme not found"));
        plateformeRepository.delete(plateforme);
    }
}
