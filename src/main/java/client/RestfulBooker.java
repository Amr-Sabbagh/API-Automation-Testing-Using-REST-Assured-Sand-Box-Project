    package client;

    import io.qameta.allure.restassured.AllureRestAssured;
    import io.restassured.builder.RequestSpecBuilder;
    import io.restassured.http.ContentType;
    import io.restassured.specification.RequestSpecification;
    import utils.Reporting;

    public class RestfulBooker {

        public RequestSpecification requestSpecification;

        private static final String RESTFUL_BOOKER_BASE_URL = System.getProperty("base.url","https://restful-booker.herokuapp.com");

        public RestfulBooker(){
            this.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(RESTFUL_BOOKER_BASE_URL)
                    .setAccept(ContentType.JSON)
                    .addHeader("Accept", "application/json")
                    .addFilter(new Reporting())
                    .build();
        }

        public RestfulBooker(String authToken){
            this.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(RESTFUL_BOOKER_BASE_URL)
                    .setAccept(ContentType.JSON)
                    .addHeader("Accept", "application/json")
                    .addCookie("Cookie",authToken)
                    .addFilter(new Reporting())
                    .build();
        }

    }
