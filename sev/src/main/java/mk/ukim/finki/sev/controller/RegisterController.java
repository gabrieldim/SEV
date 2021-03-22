package mk.ukim.finki.sev.controller;

import mk.ukim.finki.sev.model.Role;
import mk.ukim.finki.sev.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(){
        return "signup";
    }
    @PostMapping
    public String registerUser(
            @RequestParam String embg,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname){

        userService.register(embg,password,firstname,lastname, Role.ROLE_VOTER);

        return "redirect:/login";
    }


}
