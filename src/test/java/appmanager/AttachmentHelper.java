package appmanager;

import static io.restassured.RestAssured.given;

public class AttachmentHelper extends HelperBase {

    public void sendCustomerStatements(String phone, String pass, String cliSessionId, String month, String year, String site, String deviceuuid) {
        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", site)
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic(phone, pass)
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
}
