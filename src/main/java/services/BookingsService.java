package services;

import client.RestfulBooker;
import data.Credentials;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingsService {

    private static final String BOOKINGS_ENDPOINT = System.getProperty("bookings.endpoint","/booking");

    private final RestfulBooker client;

    public BookingsService(){
        AuthenticationService authServeice = new AuthenticationService();
        Credentials credentials = new Credentials("admin", "password123");
        String authToken = authServeice.getAuthenticationToken(credentials);
        this.client = new RestfulBooker(authToken);
    }

    @Step("Get bookings IDs")
    public Response getBookingsIds (){
        // Implementation for getting booking IDs
        return given()
                    .spec(client.requestSpecification)
                .when()
                    .get(BOOKINGS_ENDPOINT)
                .then()
                    .extract()
                    .response();
    }

    @Step("Get booking by ID")
    public Response getBookingById (int bookingId){
        // Implementation for getting booking by ID
        return given()
                    .spec(client.requestSpecification)
                .when()
                    .get(BOOKINGS_ENDPOINT + "/" + bookingId)
                .then()
                    .extract()
                    .response();
    }
}
