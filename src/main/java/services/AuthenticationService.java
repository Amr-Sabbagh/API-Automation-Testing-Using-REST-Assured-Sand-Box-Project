package services;

import client.RestfulBooker;
import data.Credentials;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class AuthenticationService {

    private static final String AUTHENTICATION_ENDPOINT = System.getProperty("authorization.endpoint","/auth");

    RestfulBooker client = new RestfulBooker();

    public String getAuthenticationToken(Credentials credentials){
        return given()
                    .spec(requestSpecification)
                .when()
                    .post(AUTHENTICATION_ENDPOINT)
                .then()
                    .extract()
                    .response()
                    .jsonPath()
                    .getString("token");
    }

}
