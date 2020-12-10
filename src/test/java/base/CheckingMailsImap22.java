package base;

import com.sun.mail.util.BASE64DecoderStream;
import io.restassured.internal.util.IOUtils;
import org.apache.commons.codec.binary.Base64;

import javax.mail.*;
import javax.mail.internet.MimePart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;


public class CheckingMailsImap22 {
    public static String check(String host, String storeType, String user,
                             String password) throws MessagingException, IOException {
        String url = null;

        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
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
                    for (int partCount = 0; partCount < numberOfParts-1; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        // part is instanceof javax.mail.Part
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        part.getDataHandler().writeTo(bos);

                        String decodedContent = bos.toString();


                        System.out.println("decodedContent" + decodedContent);

                        String cutDecodedContent = null;
                        cutDecodedContent = decodedContent.substring(1410, 1668);//5064
                        System.out.println("cutDecodedContent " + cutDecodedContent);
                        url = cutDecodedContent;

                        String disposition = part.getDisposition();

                        if (disposition != null && disposition.equals(Part.INLINE)) {

                            if (part.getContent() instanceof BASE64DecoderStream) {
                                BASE64DecoderStream base64DecoderStream = (BASE64DecoderStream) part.getContent();
                                byte[] byteArray = IOUtils.toByteArray(base64DecoderStream);
                                byte[] encodeBase64 = Base64.encodeBase64(byteArray);
                                base64Content[0] = new String(encodeBase64, "UTF-8");

                                base64Content[1] = part.getContent().toString();
                                System.out.println("base64Content[0] " + base64Content[0]);
                                System.out.println("base64Content[1]" + base64Content[1]);

                            }
                            System.out.println("________________________________________________");
                            messageContent = part.getContent().toString();
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


            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }





    public static void main(String[] args) throws IOException, MessagingException {

        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username = "testdipocket@gmail.com";// pavelburinskiy
        String password = "password1<";//reset246740

        String link = check(host, mailStoreType, username, password);

        System.out.println("test_test " + link);

    }
}
