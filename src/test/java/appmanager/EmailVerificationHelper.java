package appmanager;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static javax.mail.internet.MimeUtility.decodeText;


public class EmailVerificationHelper {
    public static String appPass = "oangitprvdsqwrgh";

    public static String getTextFromEmail(String host, String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        String result = "";
        //Thread.sleep(2000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, appPass);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);  //READ_ONLY

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) { //was numberOfParts-1

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);



                        if (part.isMimeType("text/html")) {
                            String html = (String) part.getContent();
                            //result = result + "\n" + org.jsoup.Jsoup.parse(html).text();  //all letters
                            result = org.jsoup.Jsoup.parse(html).text();
                        }


                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }

                if (message.isMimeType("text/html")){
                    String html = message.getContent().toString();
                    result = org.jsoup.Jsoup.parse(html).text();
                }
                System.out.println("Message: " + messageContent);

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true);//false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("email text:  " + result);
        return result;
    }

    public static void getTextFromEmailYahoo(String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        //String host = "imap.mail.yahoo.com";
        // Sender's email ID needs to be mentioned
        String from = "testdipocket@yahoo.com";
        String pass ="pasword12!";
        // Recipient's email ID needs to be mentioned.
        String to = "testdipocket@gmail.com";
        String host = "pop.mail.yahoo.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "465");  //587
        properties.put("mail.smtp.auth", "true");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        Store store = session.getStore("pop3");

        store.connect(host, user, password);

        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_WRITE);  //READ_ONLY

        Message[] messages = emailFolder.getMessages();

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static List<String> getFileNameFromEmail(String host, String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        List<String> pdf = new ArrayList<String>();

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);

                String contentType = message.getContentType();
                String messageContent = "";


                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        if(part.isMimeType("APPLICATION/OCTET-STREAM")){

                            //pdf.add( part.getFileName());
                            String name = part.getFileName();
                            String realFileName = decodeText(name);
                            pdf.add(realFileName);
                            System.out.println("File name: " + realFileName);
                        }

                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }

            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pdf;
    }

    public static String getEmailSender(String user, String password) throws InterruptedException, MessagingException, IOException {
        String result = "";
        Thread.sleep(5000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", "pop.gmail.com");
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect("pop.gmail.com", user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);

                result = String.valueOf(message.getFrom()[0]);


            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getEmailSenderAndSubject(String user, String password) throws InterruptedException, MessagingException, IOException {
        List<String> result = new ArrayList<String>();
        //Thread.sleep(5500);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", "pop.gmail.com");
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
            System.out.println("0. Preconnect");

            Store store = emailSession.getStore("imaps");

            store.connect("pop.gmail.com", user, appPass);
            System.out.println("1. Connected");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            int count = 0;
            while(emailFolder.getMessages().length == 0 && count < 120){
                Thread.sleep(1000);
                count++;
            }
            System.out.println("count:" + count);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);

                result.add(String.valueOf(message.getFrom()[0]));
                result.add(message.getSubject());

            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getEmailSenderAndSubjectOAUTH2(String user, String password) throws InterruptedException, MessagingException, IOException {
        List<String> result = new ArrayList<String>();

        try {
//            Properties props = new Properties();
//            props.put("mail.imap.ssl.enable", "true"); // required for Gmail
//            props.put("mail.imap.auth.mechanisms", "XOAUTH2");
//            Session session = Session.getInstance(props);
//            Store store = session.getStore("imap");
            //store.connect("imap.gmail.com", user, "ya29.a0ARrdaM9KHGx3N_bxhyUduSf4KP6Owz2Gz1A9xYbM0u87o8o1ML0XAbbJ0PvdY52Tcy3xa4-nm3wrzWRPVlNVAf9bfHHIhBAcA6-WUKQLeTE5w_jckVgxeVSLQgGAWfDbsCyS-TdyvWiurffnA0TVz8eRVusm");


            System.out.println("Connecting to gmail with IMAP and OAUTH2.");
            Properties props = new Properties();
            props.put("mail.imaps.ssl.enable", "true");
            props.put("mail.imaps.sasl.enable", "true");
            props.put("mail.imaps.sasl.mechanisms", "XOAUTH2");
            props.put("mail.imaps.auth.login.disable", "true");
            props.put("mail.imaps.auth.plain.disable", "true");
            props.put("mail.debug.auth", "true");
        /*
        props.put("mail.imaps.sasl.mechanisms.oauth2.oauthToken",
                    accessToken);
        */
            System.out.println("Creating session...");
            Session session = Session.getInstance(props);
            session.setDebug(true);
            System.out.println("Creating store...");
            Store store = session.getStore("imaps");
            System.out.println("Connecting store...");
            store.connect("imap.gmail.com", 993, "911454727863-rpcm0d5am6rv2bb6odjinptbcfoae1tn.apps.googleusercontent.com", "ya29.a0ARrdaM9eoUuPxqGjfPHMTNNZzp_C8H6ScoNrwyM_uzr3lJp7vnLMzkoUE_phdRssvE8zMNyqsEi2c2Y8QOyWL-1XB-84WIYKu2hufY0xWVqDXxHeHpXLNrPw3MNjHoBMZiIKfm2F6a9wPCM1UW_4k4iiC35m");
            System.out.println("Store connected.  If we get here, things work.");




            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            int count = 0;
            while(emailFolder.getMessages().length == 0 && count < 120){
                Thread.sleep(1000);
                count++;
            }
            System.out.println("count:" + count);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);

                result.add(String.valueOf(message.getFrom()[0]));
                result.add(message.getSubject());

            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException, IOException, MessagingException {

        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username = "testdipocket@gmail.com";
        String password = "password1<";

        String text = getTextFromEmail(host,  username, password);

        System.out.println("email text:  " + text);

    }
}