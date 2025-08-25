package com.retail.api.tests;

import com.retail.api.data.TestData;
import com.retail.api.requests.UserRequests;
import com.retail.api.utils.APIUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserTests {

    private int userId;

    @Test(priority = 1)
    public void testCreateUser() {
        System.out.println("************Test 1*****************");
        Response response = UserRequests.createUser(TestData.createUserPayload());
        response.then().statusCode(201).log().body();
        userId = response.jsonPath().getInt("id"); // Storing for later tests
        System.out.println("User created with ID: " + userId);
    }

    @Test(priority = 2)
    public void testGetUserDetails() {
        System.out.println("************Test 2*****************");
        Response response = UserRequests.getUserDetails(2);
        response.then()
                .spec(APIUtils.getResponseSpecification())
                .log().body()
                .body("data.first_name", equalTo("Janet"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user-schema.json"));
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        System.out.println("************Test 3*****************");
        Response response = UserRequests.updateUser(userId, TestData.updateUserPayload());
        response.then()
                .statusCode(200)
                .body("job", equalTo("zion resident"))
                .log().body();
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        System.out.println("************Test 4*****************");
        Response response = UserRequests.deleteUser(userId);
        response.then().statusCode(204);

        // Verify deletion by trying to get the User
        Response getResponse = UserRequests.getUserDetails(userId);
        getResponse.then().statusCode(404);
    }
}