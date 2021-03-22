package mk.ukim.finki.sev.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_VOTER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
