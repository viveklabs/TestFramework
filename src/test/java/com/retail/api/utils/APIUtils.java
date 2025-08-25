package com.retail.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIUtils {

    private static final String BASE_URI = ConfigManager.getInstance().getString("base.uri");
    private static final String API_KEY =  ConfigManager.getInstance().getString("api-key");

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    // Use a static block to initialize the specifications once
    static {
        // Request Specification for common details
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("x-api-key", API_KEY)
                .setContentType(ContentType.JSON)
                .build();

        // Response Specification for common assertions
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static Response getRequest(String path) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .get(path);
    }

    public static Response postRequest(String path, String body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(path);
    }

    public static Response putRequest(String path, String body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put(path);
    }

    public static Response deleteRequest(String path) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .delete(path);
    }

    // You can add a method to get the base specification
    public static RequestSpecification getRequestSpecification() {
        return requestSpec;
    }

    public static ResponseSpecification getResponseSpecification() {
        return responseSpec;
    }
}