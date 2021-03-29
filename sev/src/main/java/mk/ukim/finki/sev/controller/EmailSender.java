package mk.ukim.finki.sev.controller;

import mk.ukim.finki.sev.service.MailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.File;

@RestController
@RequestMapping("/email")
public class EmailSender {

    private final MailSenderService mailSenderService;

    public EmailSender(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @GetMapping
    public ResponseEntity mailSending() throws MessagingException {
        File folder = new File("C:\\Users\\gabri\\Desktop\\IB\\ClientCert");
        File [] files = folder.listFiles();

        this.mailSenderService.sendMessageWithAttachment(
                "accsystem2021@gmail.com",
                "Client Certificate",
                "Hey, here is your certificate: ",
                files[0].getAbsolutePath()
        );

        return ResponseEntity.ok(files);
    }



}
