package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Nationalite;
import fr.doranco.filmeo_back.model.repository.INationaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationaliteService {

    private final INationaliteRepository nationaliteRepository;

    @Autowired
    public NationaliteService(INationaliteRepository nationaliteRepository) {
        this.nationaliteRepository = nationaliteRepository;
    }

    // Obtenir toutes les nationalités
    public List<Nationalite> getAllNationalites() {
        return nationaliteRepository.findAll();
    }

    // Obtenir une nationalité par son ID
    public Optional<Nationalite> getNationaliteById(Long id) {
        return nationaliteRepository.findById(id);
    }

    // Ajouter une nationalité
    public Nationalite addNationalite(Nationalite nationalite) {
        return nationaliteRepository.save(nationalite);
    }

    // Mettre à jour une nationalité existante
    public Nationalite updateNationalite(Long id, Nationalite nationaliteDetails) {
        Nationalite nationalite = nationaliteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Nationalité not found"));
        nationalite.setPays(nationaliteDetails.getPays());
        return nationaliteRepository.save(nationalite);
    }

    // Supprimer une nationalité
    public void deleteNationalite(Long id) {
        Nationalite nationalite = nationaliteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Nationalité not found"));
        nationaliteRepository.delete(nationalite);
    }
}
