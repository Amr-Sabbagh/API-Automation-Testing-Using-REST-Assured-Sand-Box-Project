package utils;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class Reporting implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        // Proceed with the request
        Response response = ctx.next(requestSpec, responseSpec);

        // Request details
        String requestDetails = requestSpec.getMethod() + " " + requestSpec.getURI()
                + "\n\nHeaders:\n" + requestSpec.getHeaders()
                + "\n\nBody:\n" + (requestSpec.getBody() != null ? requestSpec.getBody() : "N/A");

        // Response details
        String responseDetails = "Status Code: " + response.getStatusCode()
                + "\n\nHeaders:\n" + response.getHeaders()
                + "\n\nBody:\n" + response.asPrettyString();

        // Attach request and response
        Allure.addAttachment("Request Details",
                "text/plain",
                new ByteArrayInputStream(requestDetails.getBytes(StandardCharsets.UTF_8)),
                ".txt");

        Allure.addAttachment("Response Details",
                "text/plain",
                new ByteArrayInputStream(responseDetails.getBytes(StandardCharsets.UTF_8)),
                ".txt");

        return response;
    }
}