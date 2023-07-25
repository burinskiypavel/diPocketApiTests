package requests.aspsp;

import appmanager.SSLCertHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ConsentsRequests {
    SSLCertHelper sslCertHelper = new SSLCertHelper();

    public RequestSpecification requestSpecConsentsTest = given()
            .log().uri().log().headers().log().body()
            .baseUri("https://openbanking.dipocket.site")
            .port(3443);


    public String partnerId_bg_v1_consents(String json, String partnerId) {
        String response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                //.baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/consents/")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public Response partnerId_bg_v1_consents_confirmationOfFunds_status(String consentId, String partnerId) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("partnerId", partnerId)
                .pathParam("confirmation-of-funds", consentId)
                .get("/{partnerId}/bg/v1/consents/{confirmation-of-funds}/status");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_consents_confirmationOfFunds(String consentId, String partnerId) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .header("X-Request-ID", "ea5f8624-a086-4e8f-9d7a-f6094b871615")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .pathParam("partnerId", partnerId)
                .pathParam("confirmation-of-funds", consentId)
                .get("/{partnerId}/bg/v1/consents/{confirmation-of-funds}");
        response.then().log().all()
                .statusCode(200);
                return response;
    }

    public Response partnerId_bg_v1_accounts(String consentId, String partnerId) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("/{partnerId}/bg/v1/accounts");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_accounts_accountId(String consentId, String partnerId, String resourceId) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .pathParam("accountId", resourceId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("/{partnerId}/bg/v1/accounts/{accountId}");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_accounts_accountId_balances(String consentId, String partnerId, String resourceId) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .pathParam("accountId", resourceId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("/{partnerId}/bg/v1/accounts/{accountId}/balances");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_accounts_accountId_transactions_dateFrom_dateTo(String consentId, String partnerId, String resourceId, String dateFrom, String dateTo) {
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .pathParam("accountId", resourceId)
                .pathParam("dateFrom", dateFrom)
                .pathParam("dateTo", dateTo)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("/{partnerId}/bg/v1/accounts/{accountId}/transactions?dateFrom={dateFrom}&dateTo={dateTo}");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_accounts_accountId_transactions_transactionId(String consentId, String partnerId, String resourceId, String transactionId){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("accountId", resourceId)
                .pathParam("partnerId", partnerId)
                .pathParam("transactionId", transactionId)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("Consent-ID", consentId)
                .get("/{partnerId}/bg/v1/accounts/{accountId}/transactions/{transactionId}");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_payments_sepa_credit_transfers_paymentId(String x_Request_ID, String partnerId, String paymentId){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .pathParam("paymentId", paymentId)
                .header("X-Request-ID", x_Request_ID)
                .get("/{partnerId}/bg/v1/payments/sepa-credit-transfers/{paymentId}");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_payments_sepa_credit_transfers_paymentId_status(String x_request_ID, String partnerId, String paymentId){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .pathParam("paymentId", paymentId)
                .header("X-Request-ID", x_request_ID)
                .get("/{partnerId}/bg/v1/payments/sepa-credit-transfers/{paymentId}/status");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_payments_cross_border_credit_transfers(String x_request_ID, String partnerId, String json){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", x_request_ID)
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/payments/cross-border-credit-transfers");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_payments_domestic_credit_transfers(String x_request_ID, String partnerId, String json){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", x_request_ID)
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/payments/domestic-credit-transfers");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response partnerId_bg_v1_payments_sepa_credit_transfers(String x_request_ID, String partnerId, String json){
        Response response = given()
                .config(sslCertHelper.aspspSslConfig)
                .spec(requestSpecConsentsTest)
                .pathParam("partnerId", partnerId)
                .header("X-Request-ID", x_request_ID)
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
                .post("/{partnerId}/bg/v1/payments/sepa-credit-transfers");
        response.then().log().all()
                .statusCode(200);
        return response;
    }
}