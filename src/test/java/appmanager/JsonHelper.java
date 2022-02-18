package appmanager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonHelper extends HelperBase {

    public boolean isElementPresentInJson(Response res, String jsonPatch, String expectedValue) {
        boolean bool;
        String responseBody = res.getBody().asString();
        JsonPath js = new JsonPath(responseBody);
        String actualValue = js.getString(jsonPatch);
        System.out.println(actualValue);
        if(actualValue.equals(expectedValue)){
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    public boolean isElementPresentInJson(Response res, String jsonPatch, int expectedValue) {
        boolean bool;
        String responseBody = res.getBody().asString();
        JsonPath js = new JsonPath(responseBody);
        int actualValue = js.getInt(jsonPatch);
        System.out.println(actualValue);
        if(actualValue == (expectedValue)){
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }
}
