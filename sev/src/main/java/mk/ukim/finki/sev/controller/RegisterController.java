package mk.ukim.finki.sev.controller;

import mk.ukim.finki.sev.model.Role;
import mk.ukim.finki.sev.model.User;
import mk.ukim.finki.sev.repository.UserRepository;
import mk.ukim.finki.sev.service.MailSenderService;
import mk.ukim.finki.sev.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.File;
import java.security.Principal;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final MailSenderService mailSenderService;
    private final UserRepository userRepository;

    public RegisterController(UserService userService, MailSenderService mailSenderService, UserRepository userRepository) {
        this.userService = userService;
        this.mailSenderService = mailSenderService;
        this.userRepository = userRepository;
    }


    @GetMapping
    public String getRegisterPage(){
        return "signup";
    }

    @GetMapping("/certificate-info")
    public String getCertificateInfoPage(){
        return "certificate-info";
    }

    @PostMapping
    public String registerUser(
            @RequestParam String embg,
            @RequestParam String email,
            @RequestParam String firstname,
            @RequestParam String lastname) throws MessagingException {

        userService.register(embg,"test",firstname,lastname, Role.ROLE_VOTER,email);

        String userEmail = email;

        File folder = new File("C:\\Users\\gabri\\Desktop\\IB\\ClientCert");
        File [] files = folder.listFiles();

        String filePath = null;

        for(File f : files){
            String name = f.getName().split("\\.")[0];
            if(name.equals(embg)){
                filePath = f.getAbsolutePath();
                break;
            }
        }
        this.mailSenderService.sendMessageWithAttachment(
                userEmail,
                "Client Certificate",
                "Certificate Password: test1234",
                filePath);


        return "redirect:/register/certificate-info";
    }


}
