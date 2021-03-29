package mk.ukim.finki.sev.service;

import javax.mail.MessagingException;

public interface MailSenderService {
   void sendMessageWithAttachment( String to, String subject, String text, String pathToAttachment) throws MessagingException;
}
