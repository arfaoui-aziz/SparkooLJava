package Utils;


import javax.mail.*;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Transport.send;

public class javaMailUtil {
    public static void sendMail(String receptient, String UserName) throws MessagingException {
        System.out.println("Prep to sent");
        Properties proprieties = new Properties();
        proprieties.put("mail.smtp.auth","true");
        proprieties.put("mail.smtp.starttls.enable","true");
        proprieties.put("mail.smtp.host","smtp.gmail.com");
        proprieties.put("mail.smtp.port","587");
        proprieties.put("mail.smtp.enable","true");
        String myAccountEmail = "sparkool.project@gmail.com";
        String password = "Sparkool123";

        Session session = Session.getInstance(proprieties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

       Message message = prepareMessage(session, myAccountEmail, receptient, UserName);

        Transport.send(message);
        System.out.println("Message tebaath");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String reception, String UserName)
    {
        try {
            Message message = new MimeMessage(session) ;
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(reception));
            message.setSubject("Registration");
            String htmlCode = "<img src="+ "https://media1.tenor.com/images/06ae072fb343a704ee80c2c55d2da80a/tenor.gif?itemid=14090897"+">"+"<br>"+"<h1>congratulations your registration has been successfully submitted</h1>"
                    +"<br>"+"Your login informations"+"<br>"+"<h1> USERNAME : "+UserName+"<br>"+"Password  :"+UserName;

            message.setContent(htmlCode,"text/html");
            return message;
        }
        catch (Exception ex)
        {
            System.out.println("Exception");
        }
        return null;

    }
}
