package pl.basicstuff.dmcompanionapp.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private final pl.basicstuff.dmcompanionapp.user.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.basicstuff.dmcompanionapp.user.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.basicstuff.dmcompanionapp.user.User getUser() {
        return user;
    }
}