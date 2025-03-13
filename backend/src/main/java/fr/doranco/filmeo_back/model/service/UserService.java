package fr.doranco.filmeo_back.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.doranco.filmeo_back.model.entity.User;
import fr.doranco.filmeo_back.model.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User insert(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userRepository.save(user);
    }

    public User update(User user) {
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        if (oldUser == null) {
            return null;
        }
        if (!oldUser.getPassword().equals(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add("ROLE_USER");
        return userRepository.save(user);
    }

    public User findByPseudo(String pseudo) {
        return userRepository.findByPseudo(pseudo);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
