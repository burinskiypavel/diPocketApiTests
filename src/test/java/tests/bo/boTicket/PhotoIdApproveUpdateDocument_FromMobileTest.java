package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PhotoIdApproveUpdateDocument_FromMobileTest extends TestBase {
    String cliSessionId = null;
    String phone = app.homePageLoginPhone;
    String pass = app.homePagePass;
    String cookie = null;
    String username = app.BOusername;
    int clientId = app.homePageClientId;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_clientProfile_photoID() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("content-type", "application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .body("{\n" +
                        "  \"value\" : \"/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAIQAABtbnRyUkdC\\nIFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAA\\nAADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlk\\nZXNjAAAA8AAAAHRyWFlaAAABZAAAABRnWFlaAAABeAAAABRiWFlaAAABjAAAABRyVFJDAAABoAAA\\nAChnVFJDAAABoAAAAChiVFJDAAABoAAAACh3dHB0AAAByAAAABRjcHJ0AAAB3AAAADxtbHVjAAAA\\nAAAAAAEAAAAMZW5VUwAAAFgAAAAcAHMAUgBHAEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhZWiAA\\nAAAAAABvogAAOPUAAAOQWFlaIAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z3Bh\\ncmEAAAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABYWVogAAAAAAAA9tYAAQAAAADT\\nLW1sdWMAAAAAAAAAAQAAAAxlblVTAAAAIAAAABwARwBvAG8AZwBsAGUAIABJAG4AYwAuACAAMgAw\\nADEANv/bAEMADgoLDQsJDg0MDRAPDhEWJBcWFBQWLCAhGiQ0Ljc2My4yMjpBU0Y6PU4+MjJIYklO\\nVlhdXl04RWZtZVpsU1tdWf/bAEMBDxAQFhMWKhcXKlk7MjtZWVlZWVlZWVlZWVlZWVlZWVlZWVlZ\\nWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWf/AABEIA8AC0AMBIgACEQEDEQH/xAAYAAEBAQEB\\nAAAAAAAAAAAAAAAAAQQDAv/EABUQAQEAAAAAAAAAAAAAAAAAAAAB/8QAFQEBAQAAAAAAAAAAAAAA\\nAAAAAAH/xAAUEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwDSqACgAAACgAAKigAAAAoA\\nAKAAAAACgAAAACgAACooAAAKAAAAAoAAoACAqKACgAAAAAAAAAAAAAAAAAAKAAAoAAAIAAgAqAAl\\niVUBCqgMwKqAigAAKigAAoAAACooAACooAAAAKAAAACgAAAAoAAACooAACooAACooACCgAKigAAA\\nAAAAAAAAAAAAAKigAACKAAKACAAIAKIoIiKgqI9IDKCqggoAACgACgAAKigAAAAoigAAAoAAAAAA\\nKAAAAoAAAKigAAKgCgAKigAAoigAICoAoigAKACAAAAAAAAAAAqAAAKAAAAgAAAIqAAColVBGUBQ\\nUAAAFRQAUAABUUAAAABQAAAVAFAAAAABQAAAUAAAAAFAAABRFAVAFAABQAAAAAAAAAAAAAAAAURU\\nAAAAAAFEUAABFQAAAAEABBUBkVFUAAAUAABQAAAVAFAAABQAAAAUAAAAAAFAAAAUAAAAAUAAABUA\\nUAFEUAABUAURQAAAAAAAAAAAAAAFRQAAAAFRUAABFAQAAAEFQBFAY1BQAAABQAFAAABUUAAAABUU\\nAABUUARVAAAFAAABQAAAEAAFAAAAABQAFQBQAAAAAUQBQAAAAAAAAAAAAAUAAAAAFQAUQQAAAAEU\\nBAAY1RVAABUVQAQAFFAQFQBQFAABUUAAABBQFAABUUAABUUAAAABQAAQAAFQBQAAAURQBFAAAAAA\\nBUVAUQBQARQAAAABUAFAAAAAAAAAAAQAAQAGQBQUAAFAAAAFEUAAAAFAAABQAFQBQAAAFAAAAUAA\\nABQRQAAAAAABQAAEAAFAAAAAAABQAAAAAAAAAAAAAAAFRQAQFBAUAAEAAAAQZAVQAUAAAAAAFRQR\\nQAAAUAAAUAAFAAAABQAAIAoAAAKigigAAAAAqKAAAAAACgAAAAICoAKAAAAAAAAAAAAAAAKgAogA\\nAAAAAAAACAygqgAAAAAAAAqAKAAACgAAAoAAAKAAACgAAoAAAACooAAAAAAAKAAAAACgAAAAAAAo\\nACAAAAAAAAAAAAAAAAAAAAAAAAAAAioDKqCigAAAAAAAAoAAAACooAAKIoAAKAACgAAKigAAAAKi\\ngAAAAAoIoAAAAAKgCgAAAAAKgAoAAAAAAAAIACgAgAAAAAAAAAAAAIAAAMoCigAAAAAAAqKgKAAA\\nCgAAAoAAACooAAKAAACgAAAKigAAAAAAoAAAAAAKAIoAAAAAACooAAAAAAAAAAAAAqAAIAAAAAAA\\nAIKgAAMoCigAAAAAKigAAAAKigAAAAoAAAKIAoAKAAACgAAAKigAAAAAAoAAAAAKAAAAAAAAAAAC\\ngAAAAAAAAAAAAAAIAAAAAACKAAAgAMoCiiKAAAAAqKAAAoAigAAAqKAAAAAqKAAAqKAAAqKAAAAC\\niAKAAACgAAAAAoAAAAAAAAAAAKAAAAAAAAAAAAAAAAAgAAAAAAAgAAMoiqKIoAAAKAAACgCKAAAA\\nAACgAAAACKAACigAAAKAAAAqKAAAACiKAAAAACgAAAAAAAAAAoAAigAAAAAAAAAAAAAAAICKAIoC\\nAAAAyKiqCoAoACooAAAKCKAAAAAAAKAAAAqAigCioAoAAAKIoAAAKAAAACiKAAIAAoigAAAAACgA\\nAACooAAAAAAAAAAAAAAAAAAACCKgCoAAAMioqgACgAKigAAoAAAAAAAAAigCgAgCgACgAiiKAAKK\\nigAAACKAKACAKKACAAKIoAAAAAAAAoAAoAAAAAAAAAAAAAAAAAAAgqIAAAACKgMqoqgACgAKAAAK\\nAAAAAAAACiAAAAAACoAoAAAKAAAKKiiAAKICqAAAIoigAAKgCgAAAAAAAAooAAAAAAAAAAAAAAAA\\nAAAAioAAAAAiogyqCoAooAAqKAACgAAAAAAoAiiAAAAAAAACooAAAAKIoCoAoigKgKKigAAKigAA\\nKgCgCAAAAAAKAAAKAAAAAAAAAAAAAAAAIoAioAAAAAiogzAKCgAACgAKigAAAAAAAAKiiAAAAAAA\\nAKgAoAAACooAAoqAKAAqAKAAAAoAAAKigACAAKIAoAAAAAAAoAAAAAAAAAAAAigIAAAAAAipUGZU\\nVQIAAAigCgAKIAoAAAAAgAKKiiAAAAAAAACooAAAAKAAAKoAAACooAACooAAAAKAIAAoAAAAAAAo\\nAAAAAAAAAAAAAAACAAAAIqAAAzKigAAKAAAAAAAKIogAAAAAAAAqKoAIACgAgAoAAAACoooAAqAK\\nAAACgAAAoAAAKIogACiKAAAAAAKAAAAAAAAAAAAAAAAIqAAAgoCAIMyoqgAAqKAAAAAAAACgCAAA\\nAACigAAAAIACgAgoAAAAAqgAKgCgAAAoigAAKgCgAKgCgCAAKAAAAAAAKAAAAAAAAAAAAAAAAgqA\\nAAgqIM0VFUAABUAUAAAAAAAUQEURQAFABAVBRQAAEAAAABUAUAUAEURRQAFAAABRAFAAAAVFAAAV\\nAFAEAUUAAAAAAAAAAAAAAAAAAAAABBUAAARUQZlRVAAAARRAUVFEABQAAAQVAFAUAEABRRFAAAAQ\\nAAAAFQFUABUAUAFEUAAAAFEUAAAFAAAABQAAAUAAAAAAVAUAAABFAEVAAAAAAAEAAAAEQZlQUUAA\\nAAABUBFAFABAAAAFEUABQAAVAFAAAAAQABQAFEUAAFEUBUAUABUAFRQAAAAURQAAUAAAFAAAAAAB\\nQAAAARRAVAAAAAAEUEAAAAAQZQFFAAAAAAVARQAAAABQAQAUUAABABQBAFAAAFAAAAFRQAAFQBQA\\nURQAAFRQAAAAUAAAFEUAAFEUAAAAAAFEUAAEFQAAAAAEAAAAAAQAAZRFUFRQABAAUAAVFAAEABQA\\nABUFRQAAAEBUAURQABQAAAAABQAABRFAVAFAAABQAAAFRQAAFQBQAAAUQBQAAAAAUQAAAAAABAAA\\nAAAAAAEGURVAABUUAAAAAAFEUAAAAQVBQVFQABQAQUBQAAAAAAAAAFEUAAFEUAABQAAAVFAAAVAF\\nAAABRFAAAAAVFAAAAAAAAAAARUAAAAAAAAARRBkVFUAAFQAVFAAAABRFAAAAEFQAUAAAAAFEBQAA\\nAABQAAABUUAABUUAABUAUABUUAAAFAAAABRFAAAAAVABUAUAAAAAEUQAAAAAAEUQFQAVAQZQFRQA\\nAAABVEAUABUBFAAAAABQAAAFQBQAAAABQAQFQUFARQAAAABQAAAURQAAURQAAFRQAAFQBQAAAAAA\\nAAAFQAVAAAAAAAAQAAAAQAAZQFRRFAAFAAAAURQABFAAAAABQAAAURQAAAABQAAUAAAAAAAAVFAA\\nAAAVAFAAABRFAVAFEUAAAAFEAUAAAAAAAAAAAAABAAAAAAAQAAZQFAARQBQAAABUBFAAVFAAAABQ\\nAAAFRQAAFQBQAAAABQAAAAAFQAUAAAAABUUAAAAFAAVAFAAAAAAVAFEAUQBRFAEAUABAAAAAAAAA\\nQAQGYBQAAVFEBFFAAABFAAVAFAAABQAAAURQAAFQBQAAAAAAAABQABUAUAAAAAAAFAEAAFQFUABU\\nAUAAAAAAAAAAAAAAAAAAAAAAAAQQAAZVRVQAFABBUAUAUAEFAAAFAAABRFAAAVFAAAAAVAFEUAEB\\nRFAAAAAAAABRAFAAAAVAFEUAAUVAFEUAAAAAAFEAFQBRAFEAUQBRAFEAAAAAAAAQGZUUQAAAAAAU\\nQFABRFAABRFAAAVAFAAAAVAFEUAAAAAAAAAAFQAUQBQAAAAAURQAAAAUQFUAAABUAUQBRAFEAUQB\\nQAAAAAAAAAAAAEABQQEGZUFQUAAAAAAUAABUUAABUAUBQAQVAUUBAAAABRABUAFQBRFAEAURQAAA\\nAURQAAAAUQBQAAAAAUQBQAAAABQAAAAAAAAAAAAAAAAAAAAAGYARRFAAAAAVAFAAVAFEVQAQFQUU\\nAAAAABUAUQQURVAAAAARUAAAABUAUQBQAFQBRAFAAVAAAFEAURQAAAAAAUQFURQBFAEUARQAAAAA\\nAAAAAEVAZwBAAFEUAABUAFRQAAFQBQFAAAAAAFEUAAAAAAAAAAABAAAVAFEFFAAAQURQAAFQBRFA\\nAAAAAAABRAFEAURRQAAAAAAABUAVABRAFAABAVAQZwFQAAUAAAAAFRQAAAAAFFEAUQBRFAAAVAFE\\nAUAAEBRFABAUQBRAFAAABRFQAAFQBQAAAAAVABRAFEAURQAAABQAFEUAAAAAAAAAAAAAAAAGcEEU\\nABUAUAAAAABUAUAABQAAAAABRAFAAAAAAAAAAAAAAAAABQAAEFEUAABUAUQBRFAAAAAAAABRAFEB\\nVAAAAAAVAFRUBQAAAAAAAEVAZ1QEUAAAAFAEUAAAAAAFEFFAAAAAAAAABRAFEUAAAAAAAEBQAAAV\\nABQQFAAVBBQQFAAAAAAVABUAUQBQAAAABVEAUAAAAABUAUQBRAAAAAGcARRFAAAAAAAUAAAAAAAA\\nFFQAFQBQAAAAAAAAAAAAAAAAAAAUAAABUAUBAAAVAFEAUQBRFAAAAAAAVAFEUUAAVAFEUAAAAAAA\\nAAEBUAHAAQUAAAAAAAFQBQAAAAAAFAAAAAAFRUBQAAAAAAAAAAAAAAAFQBRFAAAAAVBBQAAAAAAA\\nAAUQBQAABQAFEUAAAABUAUAAQAAAAABAcQBBUAUAAAAAAAAABUAUAAAAAABQAAAAVAFEAUQBRFAA\\nAAAAAAAAAABRAFEAURQAEBUAFQBRFAAAAAAAVAVQAAAFQBQAAAAAAAAAAAEAHEAQABRAFEUAQBQA\\nAAAAFQBRAFAAAAAAAUAEABQAAAAAAVFABAURQAAAAAAAAAAUQQUEBRFAAAAAVAFAFAAUQBRFAAAV\\nAFEUAAAAAQAAAABwUBAABUAAAAAUQBQAAAAAAAAAURQAAAAAAAAAAAAAAAFAAABAVAFEUAAARQAA\\nAAAAAAFQBQAAAFRRQAAAAAFEAUAAAAAAAAAAABAByEUQAAAAAAAAVAAAFBAUAAAAAAABUAUQBQAA\\nAAQFAABAUAAAAAAAAABUAAAAAURQAAAAAAFQBRFAAFAAUAAAAAFEAUAAAAQBRAFBAVABxVARQAAA\\nAAAAAAAAAAUQBRAFEUAAAAAAFEAUQBRAFEAAAFQBUAFEUAAAAAAAAAAAAAAFAAAAAAAAVAFAFAAU\\nQBQAAAAAAAAAAEABQABxAEURQAQFAAAAAAAAAAVAAAAAAAFEAURQAAAAAAAAAAAAAAAAFQBQAAAA\\nAAAAAAAAAUAAAAAAAAAFAAAFAAFQBRAFAABAUBAAARUByAVBUAUEAVAFAAAAAAAAAAAAAAAAAAAB\\nRFAAAAAAAAAAAAAAAAAAAUQFEAUAAAAAAAFQAUQBQAAAAAFQBRAVQBAAUAEABVQAVBRAQRQAHFUV\\nUAAAAAAAAFQBUAFEAURQAAAAAAAAAAAAURQAAAAAAAAAAAAAAAAAAAAVABQAAAAAAAAUEVABUAUA\\nAAAAAAFQUARQABQAAAQAQAQHIRVFEAUEBQAAAAAAAAAAAURQAAAAAAAAAAAUAAAAAAAAAAAAAAAA\\nAAAAAABQAAAAAAAAAABUFABAURQAAAAAAAAAAFRRQEEUQBUBFcVQVFAAAAVAFEUAAAAAAAAAABUA\\nUAAAAAAAAFAAAAAAAAAAAAAAAAAAAAAAAAAVABUUAAAAAAAAAAAFAEAUAAAAAAAAAUAQAAAQHIRV\\nQABRAFAAVFAEUAAAAAAAAAAFAAAAAAABRFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAVAFAAAAAAAAAA\\nABQQFEUAEBQBQEQVABRAAAHFUFRRFAAAVFAAAVAFQAUEBQAAAAAFRQAAAAFQAUQFAAAAAARQAAAA\\nEUABFAEAVBQBFAAAAAAAAAABRAFAAAAAAAAAAAAAAAQABQAQAFAAcQFQVAFAAAAVFAEUAAAAFAAA\\nAAAUAAAAAAAAUAAAAAAAAAAAAEUQAABUAUQAVFAAAAAAAAAAAAFFEEUQBRFAAAEBVARABVARBUAR\\nRABUBQAHFUVUAAFRQAAAAFRQAAFQBQAAAAAURQAAAAAUEUAAAAAAAAAAAAAQAAAAABUAAAUAAAAA\\nAAAAUAEAAVAAAAVAABAAAAAAFAAAAABAAHEBRRAFABRAFAAABRFAAAVFAAAAABQAAAAAAFQBQAAA\\nAABFAEAAAAAAAAAAAAAFQBRAFEUAAAAAAAAABAAAAoAgCiAqggiiAqiAKgAKgAqAjkAoAAKgCqgC\\niKAAACgAAAAKigAAAAogCgAAAAAAAKgAAAAAAAAAAAAAAAAAAAIoAAAAAAKIAoIAqAKCIKgKKgIA\\nAAAAAAAAAoAAAAoA/9k=\\n\"\n" +
                        "}")
                .when()
                .put("clientProfile/photoID")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_ticket_take() {
        for(int i = 0; i < 12; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("PhotoID change")){
                break;
            }

            if(!actualTypeName.equals("PhotoID change")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "PhotoID change");
    }

    @Test(priority = 5)
    public void test_BOServices_v1_clientId_changeDoc_approve() {
        app.getBoRequestsHelper().boServices_v1_clientId_changeDoc_approve(cookie, clientId, 2, ticketId);
    }
}