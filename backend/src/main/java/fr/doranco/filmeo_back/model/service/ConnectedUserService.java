package fr.doranco.filmeo_back.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.doranco.filmeo_back.model.entity.ConnectedUser;
import fr.doranco.filmeo_back.model.entity.User;
import fr.doranco.filmeo_back.model.repository.IUserRepository;

@Service
public class ConnectedUserService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        User user = userRepository.findByPseudo(pseudo);
        return new ConnectedUser(user);
    }
}
