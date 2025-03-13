package fr.doranco.filmeo_back.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.doranco.filmeo_back.model.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
    public User findByPseudoOrEmail(String pseudo, String email);
    public User findByPseudo(String pseudo);
}
