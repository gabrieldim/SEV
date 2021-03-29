package mk.ukim.finki.sev.service.impl;

import mk.ukim.finki.sev.model.Role;
import mk.ukim.finki.sev.model.User;
import mk.ukim.finki.sev.repository.UserRepository;
import mk.ukim.finki.sev.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(String embg, String password, String firstName, String lastName, Role role, String email) {
        User user = new User(embg, firstName, lastName, this.passwordEncoder.encode(password), role, email);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new RuntimeException());
    }
}
