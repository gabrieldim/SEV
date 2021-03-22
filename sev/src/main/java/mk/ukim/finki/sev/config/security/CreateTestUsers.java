package mk.ukim.finki.sev.config.security;

import mk.ukim.finki.sev.model.Role;
import mk.ukim.finki.sev.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CreateTestUsers {

    private final UserService userService;

    public CreateTestUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createTestUser() {
        this.userService.register("test", "test", "test", "test", Role.ROLE_VOTER);
    }
}
