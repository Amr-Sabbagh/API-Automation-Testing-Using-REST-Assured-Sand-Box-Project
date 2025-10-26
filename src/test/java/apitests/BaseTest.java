package apitests;

import org.junit.jupiter.api.BeforeAll;
import services.BookingsService;

public class BaseTest {

    protected static BookingsService service;

    @BeforeAll
    public static void TestSetup(){
        service = new BookingsService();
    }

}
