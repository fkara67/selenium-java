package API.HandlingDynamicJson;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
    }
}
