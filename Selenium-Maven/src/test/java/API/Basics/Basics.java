package API.Basics;

import API.Files.Payloads;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {
        // validate if Add Place API is working as expected

        /*
        given - all input details
        when  - Submit the API
        Then  - validate the response
         */

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(Payloads.addPlace()).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.41 (Ubuntu)");

        // Add Place -> update place with new address -> get place to validate if new address is present in response

    }
}
