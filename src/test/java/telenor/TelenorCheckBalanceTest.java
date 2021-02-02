package telenor;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TelenorCheckBalanceTest extends TestBase {
    String token = "512047269";

    @Test(priority = 1)
    public void test_WebServices_v1_anonymous_bandBalance(){
        Response res = given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
                .body("{\n" +
                        "  \"publicToken\" : \""+token+"\"\n" +
                        "}\n")
                .when()
                .post(app.dipocket3_intranet+"/WebServices/v1/anonymous/bandBalance");
        res.then().log().all();

        app.getJsonHelper().checkStatusCodeIs200(res);
        app.getJsonHelper().checkResponseHasItemWithValue(res, "publicToken", "512047269");
        app.getJsonHelper().checkResponseHasItemWithValue(res, "ccy", "HUF");
        app.getJsonHelper().checkResponseHasItemWithValue(res, "availableBalance", 200000);
    }
}
