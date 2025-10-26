package apitests.bookingservice;

import apitests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class CreateBookingTest extends BaseTest {

    Response response;
    @Step
    @BeforeEach
    public void setup() {
        response = service.getBookingsIds();
    }

    @Test
    @Description("Verify that the status code is 200")
    public void successfulStatusCodeIs200() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Description("Verify that the response contains a list of booking ids")
    public void responseListIsNotNull(){
        var bookingsIds = response.jsonPath().getList("bookingid");
        Assertions.assertNotNull(bookingsIds);
    }
    @Test
    @Description("Verify that the response contains at least one booking id")
    public void responseIsNotEmpty(){
        var bookingsIds = response.jsonPath().getList("bookingid");
        Assertions.assertFalse(bookingsIds.isEmpty());
    }
}
