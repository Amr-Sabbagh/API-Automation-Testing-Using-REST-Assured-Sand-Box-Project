package services;

import client.RestfulBooker;
import data.Credentials;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class AuthenticationService {

    private static final String AUTHENTICATION_ENDPOINT = System.getProperty("authorization.endpoint","/auth");

    RestfulBooker client = new RestfulBooker();

    @Step("Get authentication token")
    public String getAuthenticationToken(Credentials credentials){
        return given()
                    .spec(client.requestSpecification)
                    .body(credentials)
                .when()
                    .post(AUTHENTICATION_ENDPOINT)
                .then()
                    .extract()
                    .response()
                    .jsonPath()
                    .getString("token");
    }

}
