package appmanager;

import com.sun.mail.util.BASE64DecoderStream;
import io.restassured.internal.util.IOUtils;
import org.apache.commons.codec.binary.Base64;

import javax.mail.*;
import javax.mail.internet.MimePart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class EmailIMAPHelper extends HelperBase {
    public static String appPass = "oangitprvdsqwrgh";

    public void deleteLettersFromEmail(String host, String user, String password){
        try {

            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            System.out.println("0. Preconnect");
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, appPass);
            System.out.println("1. Connected");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

//            int count = 0;
//            while(emailFolder.getMessages().length == 0 && count < 120){
//                Thread.sleep(1000);
//                count++;
//            }
//            System.out.println("count:" + count);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Received Date: " + message.getReceivedDate());
                System.out.println("From: " + message.getFrom()[0]);


                System.out.println("deleted");
                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String getLinkFromEmailAfterRegistration(String host, String user,
                                                           String password, String expectedSubject) throws InterruptedException {
        String emailLink = null;

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            System.out.println("0. Preconnect");
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, appPass);
            System.out.println("1. Connected");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

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

                if(!message.getSubject().equals(expectedSubject)){
                    System.out.println("deleted");
                    message.setFlag(Flags.Flag.DELETED, true);
                    //emailFolder.close(true); //false
                    //store.close();
                    continue;
                }

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts-3; partCount++) { //was numberOfParts-1

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        // part is instanceof javax.mail.Part
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        part.getDataHandler().writeTo(bos);

                        String decodedContent = bos.toString();


                        System.out.println("decodedContent" + decodedContent);

                        String cutDecodedContent = null;


                        String[] results = decodedContent.split("href=\"");
                        String DescriptionTxt = results[0];
                        String linkStr = results[1];

                        String[] results2 = linkStr.split("\">");

                        String linkStr2 = results2[0];
                        String DescriptionTxt2  = results2[1];

                        //String lin = linkStr.substring(258, 2062);


                        //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                        //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                        //emailLink = cutDecodedContent;
                        emailLink = linkStr2;
                        System.out.println("emailLink " + emailLink);

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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getLinkFromEmailAfterRegistrationSnowAttack(String user, String password, String appPass) throws InterruptedException {
        String host = "pop.gmail.com";
        String emailLink = null;

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, appPass);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

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

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        if(part.isMimeType("TEXT/HTML")){
                            // part is instanceof javax.mail.Part
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            part.getDataHandler().writeTo(bos);

                            String decodedContent = bos.toString();


                            System.out.println("decodedContent" + decodedContent);

                            String cutDecodedContent = null;


                            String[] results = decodedContent.split("href=\"");
                            String DescriptionTxt = results[0];
                            String linkStr = results[1];

                            String[] results2 = linkStr.split("\">");

                            String linkStr2 = results2[0];
                            //String DescriptionTxt2  = results2[1];

                            //String lin = linkStr.substring(258, 2062);


                            //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                            //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                            //emailLink = cutDecodedContent;
                            emailLink = linkStr2;
                            System.out.println("emailLink " + emailLink);
                        }



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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getLinkFromEmailAfterRegistrationSodexo(String user, String password) throws InterruptedException {
        String host = "pop.gmail.com";
        String emailLink = null;
        //Thread.sleep(4000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

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

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        if(part.isMimeType("TEXT/HTML")){
                            // part is instanceof javax.mail.Part
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            part.getDataHandler().writeTo(bos);

                            String decodedContent = bos.toString();


                            System.out.println("decodedContent" + decodedContent);

                            String cutDecodedContent = null;


                            String[] results = decodedContent.split("href=\"");
                            String DescriptionTxt = results[0];
                            String linkStr = results[2];

                            String[] results2 = linkStr.split("\"");

                            String linkStr2 = results2[0];
                            //String DescriptionTxt2  = results2[1];

                            //String lin = linkStr.substring(258, 2062);


                            //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                            //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                            //emailLink = cutDecodedContent;
                            emailLink = linkStr2;
                            System.out.println("emailLink " + emailLink);
                        }



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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getLinkFromEmailAfterRegistrationDiscontu(String user, String password, String appPass) throws InterruptedException {
        String host = "pop.gmail.com";
        String emailLink = null;
        //Thread.sleep(4000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            //store.connect(host, user, password);
            store.connect(host, user, appPass);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

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

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        if(part.isMimeType("TEXT/HTML")){
                            // part is instanceof javax.mail.Part
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            part.getDataHandler().writeTo(bos);

                            String decodedContent = bos.toString();


                            System.out.println("decodedContent" + decodedContent);

                            String cutDecodedContent = null;


                            String[] results = decodedContent.split("href=\"");
                            String DescriptionTxt = results[0];
                            String linkStr = results[1];

                            String[] results2 = linkStr.split("\"");

                            String linkStr2 = results2[0];
                            //String DescriptionTxt2  = results2[1];

                            //String lin = linkStr.substring(258, 2062);


                            //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                            //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                            //emailLink = cutDecodedContent;
                            emailLink = linkStr2;
                            System.out.println("emailLink " + emailLink);
                        }



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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getLinkFromEmailAfterRegistrationPlayIT(String user, String password, String appPass) throws InterruptedException {
        String host = "pop.gmail.com";
        String emailLink = null;
        //Thread.sleep(4000);

        try {

            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");

            store.connect(host, user, appPass);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);//READ_ONLY

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

                //System.out.println("Text: " + message.getContent().toString());

                String contentType = message.getContentType();
                String messageContent = "";


                String[] base64Content = new String[2];

                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    System.out.println("numberOfParts: " + numberOfParts);
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {

                        MimePart part = (MimePart) multiPart.getBodyPart(partCount);

                        if(part.isMimeType("TEXT/HTML")){
                            // part is instanceof javax.mail.Part
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            part.getDataHandler().writeTo(bos);

                            String decodedContent = bos.toString();


                            System.out.println("decodedContent" + decodedContent);

                            String cutDecodedContent = null;


                            String[] results = decodedContent.split("href=\"");
                            String DescriptionTxt = results[0];
                            String linkStr = results[1];

                            String[] results2 = linkStr.split("\"");

                            String linkStr2 = results2[0];
                            //String DescriptionTxt2  = results2[1];

                            //String lin = linkStr.substring(258, 2062);


                            //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                            //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                            //emailLink = cutDecodedContent;
                            emailLink = linkStr2;
                            System.out.println("emailLink " + emailLink);
                        }



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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getLinkFromEmailAfterChangeEmailTelenor(String host, String user,
                                                                 String password) throws InterruptedException {
        String emailLink = null;
        //Thread.sleep(4000);

        try {
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect(host, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE); //READ_ONLY

            emailFolder.getMessages();

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

                        // part is instanceof javax.mail.Part
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        part.getDataHandler().writeTo(bos);

                        String decodedContent = bos.toString();


                        System.out.println("decodedContent" + decodedContent);

                        String cutDecodedContent = null;


                        String[] results = decodedContent.split("href=");
                        String DescriptionTxt = results[0];
                        String linkStr = results[1];

                        String[] results2 = linkStr.split("> ");

                        String linkStr2 = results2[0];
                        String DescriptionTxt2  = results2[1];

                        //String lin = linkStr.substring(258, 2062);


                        //cutDecodedContent = decodedContent.substring(1410, 1668);// for idea
                        //cutDecodedContent = decodedContent.substring(2052, 2310);//for console local

                        //emailLink = cutDecodedContent;
                        emailLink = linkStr2;
                        System.out.println("emailLink " + emailLink);

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

                message.setFlag(Flags.Flag.DELETED, true);
            }

            emailFolder.close(true); //false
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailLink;
    }

    public static String getEmailFooterText(String emailText, int begin) {
        String emailFooter = cutText(emailText, begin);
        System.out.println("email footer:  " + emailFooter);
        return emailFooter;
    }

    public static String getEmailBodyText(String emailText, int begin, int end) {
        String emailBody = cutText(emailText, begin, end);
        System.out.println("email body:  " + emailBody);
        return emailBody;
    }


    public static void main(String[] args) throws InterruptedException {

        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username = "testdipocket@gmail.com";
        String password = "password1<";

        String link = getLinkFromEmailAfterRegistration(host,  username, password, "Условия пользования приложением DiPocket - пожалуйста, сохраните это сообщение");

        System.out.println("test_test " + link);

    }
}