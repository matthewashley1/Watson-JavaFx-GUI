package sample;

/**
 * Created by matthewashley on 1/10/16.
 */
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class Email {

    public void SendEmail () {

        final String username = "username@gmail.com";
        final String password = "password!";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("username@gmail.com"));
            message.setSubject("Weekly Views of Videos");
                /*
                 message.setContent("<h: body style=background-color:white;font-family:verdana;color:#0066CC;>"
                 +"If you are getting this you wrote your first email!<br/><br/>"
                 +"</body>","text/html; charset=utf-8");
                 */


            String file = "File string of file to be emailed";
            String fileName = "Video views";
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);


            message.setContent(multipart);


            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}


