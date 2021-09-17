package appmanager;

import static io.restassured.RestAssured.given;

public class AttachmentHelper extends HelperBase {

    public void sendCustomerStatements(String phone, String pass, String cliSessionId, String month, String year, String site, String deviceuuid, String prefix) {
        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", site)
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic(prefix + phone, pass)
                .header("clisessionid", cliSessionId)
                .contentType("application/json")
                .body("{\n" +
                        "  \"reportTypeId\": 1,\n" +
                        "  \"statementRequestList\": [\n" +
                        "    {\n" +
                        "      \"month\": \"" + month + "\",\n" +
                        "      \"year\": \"" + year + "\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .put("/dashBoard/sendCustomerStatements")
                .then().log().all()
                .statusCode(200);
    }

    public void sendLegalInfo2(String phone, String pass, String cliSessionId, String nameForClient, String nameForEmail, String type, String site, String prifix) {
        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", site)
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.login.deviceuuid"))
                .auth().preemptive().basic(prifix + phone, pass)
                .header("clisessionid", cliSessionId)
                .contentType("application/json")
                .body("{\n" +
                        "  \"documentList\": [\n" +
                        "    {\n" +
                        "      \"nameForClient\": \"" + nameForClient + "\",\n" +
                        "      \"nameForEmail\": \"" + nameForEmail + "\",\n" +
                        "      \"selected\": true,\n" +
                        "      \"type\": \"" + type + "\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("clientProfile/sendLegalInfo2")
                .then().log().all()
                .statusCode(200);
    }
}
