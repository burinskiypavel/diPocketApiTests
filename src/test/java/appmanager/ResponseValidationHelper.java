package appmanager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResponseValidationHelper extends HelperBase {

    public void checkStatusCodeIs200(Response res) {
        assertThat(res.getStatusCode(), equalTo(200));
    }

    public void checkResponseHasItemWithValue(Response res, String item, String value) {
        assertThat(res.getBody().jsonPath().get(item), equalTo(value));
    }
    public void checkResponseHasItemWithValue(Response res, String item, int value) {
        assertThat(res.getBody().jsonPath().get(item), equalTo(value));
    }

    public void checkResponseHasItemWithValue(Response res, String item, boolean value) {
        assertThat(res.getBody().jsonPath().get(item), equalTo(value));
    }

    public String getStringFromResponseJsonPath(String response, String path){
        JsonPath jsonPath = new JsonPath(response);
        String textFromResponse = jsonPath.getString(path);
        return textFromResponse;
    }

    public int getIntFromResponseJsonPath(String response, String path){
        JsonPath jsonPath = new JsonPath(response);
        int valueFromResponse = jsonPath.getInt(path);
        return valueFromResponse;
    }
}