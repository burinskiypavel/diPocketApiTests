package appmanager;

import javax.mail.*;
import javax.mail.internet.MimePart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class EmailVerificationHelper {
    public static String getTextFromEmail(String host, String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        String result = "";
        Thread.sleep(2000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

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
                            pdf.add(part.getFileName());
                            //pdf = part.getContentType();
                            System.out.println("File name: " + part.getFileName());
                            //System.out.println(part.getContentType());
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

            Store store = emailSession.getStore("imaps");

            store.connect("pop.gmail.com", user, password);

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
