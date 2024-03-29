package tests.bo.boOperations;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import model.bo.boOperations.CorpClientCreateRequest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CreatCorporateClientWithAccountTest extends TestBase {
    String cookie = null;
    String site = Site.DIPOCKET.toString();
    int currencyId = 978;
    int countryId = 440;
    String countryCode = "LT";
    String companyName = "Predict";
    CorpClientCreateRequest corpClientCreateRequest = new CorpClientCreateRequest();
    Gson gson = new Gson();

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin2, app.CBOuserPass2, app.CBOusername2);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_corpClient_checkSysParam_site(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("key", Site.DIPOCKET.toString())
                .when()
                .get( "/v1/user/corpClient/checkSysParam/site/{key}")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(false));
    }
    @Test(priority = 3)
    public void test_BOServices_v1_user_corpClients_createScreened(){
        corpClientCreateRequest.setAccName("TestAcc");
        corpClientCreateRequest.setAccTypeId(1);
        corpClientCreateRequest.setAccountContractCountryId(440);
        corpClientCreateRequest.setIdentifyCode(12132131231l);
        corpClientCreateRequest.setStateMail("String");
        corpClientCreateRequest.setStateReg("String");
        corpClientCreateRequest.setSite(site);
        corpClientCreateRequest.setClientType("C");
        corpClientCreateRequest.setLangId(1);
        corpClientCreateRequest.setCompanyName(companyName);
        corpClientCreateRequest.setCurrencyId(currencyId);
        corpClientCreateRequest.setDdStatus("FDD");
        corpClientCreateRequest.setFeeTariffPlanId(2);
        corpClientCreateRequest.setDefCardProgramId(1);
        corpClientCreateRequest.setLimitPlanId(2);
        corpClientCreateRequest.setOperLimitPlanId(1);
        corpClientCreateRequest.setStreetLine1Reg("Main str");
        corpClientCreateRequest.setStreetLine2Reg("50");
        corpClientCreateRequest.setCityReg("Krakiv");
        corpClientCreateRequest.setZipReg(2123123);
        corpClientCreateRequest.setCountryIdReg(countryId);
        corpClientCreateRequest.setRegisteredAddrAsMail(false);
        corpClientCreateRequest.setStreetLine1Mail("Main str");
        corpClientCreateRequest.setStreetLine2Mail("50");
        corpClientCreateRequest.setCityMail("Krakiv");
        corpClientCreateRequest.setZipMail(2123123);
        corpClientCreateRequest.setCountryIdMail(countryId);
        corpClientCreateRequest.setContractCountryId(countryId);
        corpClientCreateRequest.setCitizenship(countryCode);

        String json = gson.toJson(corpClientCreateRequest);

        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .body(json)
//                .body("{\n" +
//                        "  \"accName\" : \"TestAcc\",\n" +
//                        "  \"accTypeId\" : \"1\",\n" +
//                        "  \"accountContractCountryId\" : \"440\",\n" +
//                        "  \"identifyCode\" : \"12132131231\",\n" +
//                        "  \"stateMail\" : \"String\",\n" +
//                        "  \"stateReg\" : \"String\",\n" +
//                        "  \"site\" : \""+site+"\",\n" +
//                        "  \"clientType\" : \"C\",\n" +
//                        "  \"langId\" : 1,\n" +
//                        "  \"companyName\" : \""+companyName+"\",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"ddStatus\" : \"FDD\",\n" +
//                        "  \"feeTariffPlanId\" : 2,\n" +
//                        "  \"defCardProgramId\" : 1,\n" +
//                        "  \"limitPlanId\" : 2,\n" +
//                        "  \"operLimitPlanId\" : 1,\n" +
//                        "  \"streetLine1Reg\" : \"Gagarina ave\",\n" +
//                        "  \"streetLine2Reg\" : \"62\",\n" +
//                        "  \"cityReg\" : \"Krakiv\",\n" +
//                        "  \"zipReg\" : \"2123123\",\n" +
//                        "  \"countryIdReg\" : "+countryId+",\n" +
//                        "  \"registeredAddrAsMail\" : false,\n" +
//                        "  \"streetLine1Mail\" : \"Gagarina ave\",\n" +
//                        "  \"streetLine2Mail\" : \"62\",\n" +
//                        "  \"cityMail\" : \"Krakiv\",\n" +
//                        "  \"zipMail\" : \"2123123\",\n" +
//                        "  \"countryIdMail\" : "+countryId+",\n" +
//                        "  \"contractCountryId\" : "+countryId+",\n" +
//                        "  \"citizenship\" : \""+countryCode+"\"\n" +
//                        "}")
                .when()
                .post( "/v1/user/corpClients/createScreened")
                .then().log().all()
                .statusCode(200);
    }
}