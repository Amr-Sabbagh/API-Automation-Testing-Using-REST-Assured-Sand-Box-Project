package apitests.bookingservice;

import apitests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class CreateBookingTest extends BaseTest {

    Response response;
    @BeforeEach
    public void setup() {
        response = service.getBookingsIds();
    }

    @Test
    public void successfulStatusCodeIs200() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void responseListIsNotNull(){
        var bookingsIds = response.jsonPath().getList("bookingid");
        Assertions.assertNotNull(bookingsIds);
    }
    @Test
    public void responseIsNotEmpty(){
        var bookingsIds = response.jsonPath().getList("bookingid");
        Assertions.assertFalse(bookingsIds.isEmpty());
    }
}
