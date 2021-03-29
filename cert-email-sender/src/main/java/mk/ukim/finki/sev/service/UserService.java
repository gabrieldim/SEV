package mk.ukim.finki.sev.service;

import mk.ukim.finki.sev.model.Role;
import mk.ukim.finki.sev.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String embg, String password, String firstName, String lastName, Role role, String email);
}
