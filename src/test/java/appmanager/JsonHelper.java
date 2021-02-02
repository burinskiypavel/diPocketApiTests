package appmanager;

import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonHelper extends HelperBase {

    public void checkStatusCodeIs200(Response res) {
        assertThat(res.getStatusCode(), equalTo(200));
    }

    public void checkResponseHasItemWithValue(Response res, String item, String value) {
        assertThat(res.getBody().jsonPath().get(item), equalTo(value));
    }
    public void checkResponseHasItemWithValue(Response res, String item, int value) {
        assertThat(res.getBody().jsonPath().get(item), equalTo(value));
    }
}
