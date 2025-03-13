package fr.doranco.filmeo_back.model.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ConnectedUser implements UserDetails {

    private final User user;

    public ConnectedUser(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return this.user.getPseudo();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).toList();
    }

}
