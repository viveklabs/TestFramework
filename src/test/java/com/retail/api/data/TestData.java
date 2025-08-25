package com.retail.api.data;

import org.json.JSONObject;

public class TestData {

    public static JSONObject createUserPayload() {
        JSONObject payload = new JSONObject();
        payload.put("name", "morpheus");
        payload.put("job", "leader");
        return payload;
    }

    public static JSONObject updateUserPayload() {
        JSONObject payload = new JSONObject();
        payload.put("name", "morpheus");
        payload.put("job", "zion resident");
        return payload;
    }
}