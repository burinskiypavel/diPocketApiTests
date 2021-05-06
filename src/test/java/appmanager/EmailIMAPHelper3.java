package appmanager;

import javax.mail.*;
import javax.mail.internet.MimePart;
import java.io.IOException;
import java.util.Properties;


public class EmailIMAPHelper3 {
    public static String getTextFromEmail(String host, String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        String result = "";
        Thread.sleep(4000);

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

        return result;
    }

    public static String getEmailSender(String host, String user,
                                          String password) throws InterruptedException, MessagingException, IOException {
        String result = "";
        Thread.sleep(4000);

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

                result = String.valueOf(message.getFrom()[0]);


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
