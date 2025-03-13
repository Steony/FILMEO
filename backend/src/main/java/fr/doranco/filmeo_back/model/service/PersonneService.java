package fr.doranco.filmeo_back.model.service;

import fr.doranco.filmeo_back.model.entity.Personne;
import fr.doranco.filmeo_back.model.repository.IPersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    private final IPersonneRepository personneRepository;

    @Autowired
    public PersonneService(IPersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    // Obtenir toutes les personnes
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    // Obtenir une personne par son ID
    public Optional<Personne> getPersonneById(Long id) {
        return personneRepository.findById(id);
    }

    // Ajouter une personne
    public Personne addPersonne(Personne personne) {
        // Ajout du metier, et autres attributs
        return personneRepository.save(personne);
    }

    // Mettre à jour une personne existante
    public Personne updatePersonne(Long id, Personne personneDetails) {
        Personne personne = personneRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne not found"));
        personne.setNom(personneDetails.getNom());
        personne.setPrenom(personneDetails.getPrenom());
        personne.setGenre(personneDetails.getGenre());
        personne.setMetier(personneDetails.getMetier());  // Mise à jour du métier
        personne.setDateNaissance(personneDetails.getDateNaissance());
        personne.setDateDeces(personneDetails.getDateDeces());
        personne.setNationalite(personneDetails.getNationalite());  // N'oubliez pas de gérer la nationalité
        return personneRepository.save(personne);
    }

    // Supprimer une personne
    public void deletePersonne(Long id) {
        Personne personne = personneRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne not found"));
        personneRepository.delete(personne);
    }
}
