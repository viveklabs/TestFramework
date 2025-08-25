package com.retail.api.requests;

import com.retail.api.utils.APIUtils;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UserRequests {

    private static final String BASE_PATH = "/api/users";

    public static Response createUser(JSONObject payload) {
        return APIUtils.postRequest(BASE_PATH, payload.toString());
    }

    public static Response getUserDetails(int UserId) {
        return APIUtils.getRequest(BASE_PATH + "/" + UserId);
    }

    public static Response updateUser(int UserId, JSONObject payload) {
        return APIUtils.putRequest(BASE_PATH + "/" + UserId, payload.toString());
    }

    public static Response deleteUser(int UserId) {
        return APIUtils.deleteRequest(BASE_PATH + "/" + UserId);
    }
}