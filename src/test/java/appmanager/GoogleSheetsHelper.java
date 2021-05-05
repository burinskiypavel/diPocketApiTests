package appmanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Arrays;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class GoogleSheetsHelper {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Google Sheets Example";
    private static String SPREADSHEET_ID = "1uYgbLvp7xrNSqLgH0hc8hAaqAnHbHs17mJStn1tCcmE";
    private static int index;
    private static int indexx = 0;
    public static String token;
    public static int number = 0;
    public static  int indexForUpdate;

    private static Credential authorize()throws IOException, GeneralSecurityException{
        InputStream in = GoogleSheetsHelper.class.getResourceAsStream("/credentials.json");

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;
    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static String start() throws IOException, GeneralSecurityException{
        sheetsService = getSheetsService();

//        ValueRange body = new ValueRange()
//                .setValues(Arrays.asList(
//                        Arrays.asList("updated")
//                ));
//
//        UpdateValuesResponse result = sheetsService.spreadsheets().values()
//                .update(SPREADSHEET_ID, "D124", body)
//                .setValueInputOption("RAW")
//                .execute();

        String range = "List1!A2:D290";

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if(values == null || values.isEmpty()){
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                if (row.size() == 1) {
                    System.out.println("token: " + row.get(0));
                } else if(row.size() == 3){
                    System.out.println("token: " + row.get(0)+ " number: " + row.get(1) + " thirdColumn: " + row.get(2));
                }
                else if(row.size() == 4){
                    System.out.println("token: " + row.get(0)+ " number: " + row.get(1) + " thirdColumn: " + row.get(2) + " isExpired: " + row.get(3));
                }
                else {
                    System.out.println("token: " + row.get(0) + " number: " + row.get(1));
                    //System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
                }

            }

            for(int i = 0; i < values.size(); i++){
                if(values.get(i).contains("Pavel autotests") && !values.get(i).contains("Expired")){
                    indexx = i;
                    break;
                }
                if(!values.contains("Expired")){
                //if(!values.contains("Expired") && values.contains("Pavel autotests")){
                    if(values.get(i).contains("Expired")){
                        System.out.println("Expired: " + values.get(i));
                        number = i;
                    } else if (!values.get(i).contains("Expired")){
                        System.out.println("notExpired  " + values.get(i).get(0));
                    }
                }
            }

            if(indexx == 0) {
                index = number + 1;
                token = (String) values.get(index).get(0);
                System.out.println("index " + index);
                System.out.println("right token " + token);
            }
            else {
                token = (String) values.get(indexx).get(0);
                System.out.println("index " + indexx);
                System.out.println("right token " + token);
            }
        }

        if(indexx == 0) {
            indexForUpdate = index + 2;
        }
        else {
            indexForUpdate = indexx + 2;
        }

        ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Expired")
                ));

        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "D"+indexForUpdate, body)
                .setValueInputOption("RAW")
                .execute();

        return token;
    }
}

