package org.tests.rats.workers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {
    int statusCode;
    Map<String, String> headers;
    JsonObject body;

    public RestResponse(Response response) {
        statusCode = response.getStatusCode();//Read status code

        Headers responseHeaders = response.getHeaders();//Read Headers
        headers = new HashMap<>();
        for(Header header: responseHeaders){
            headers.put(header.getName(), header.getValue());
        }

        String json = response.getBody().asString();//Read Body
        JsonParser parser = new JsonParser();
        try {
            body = parser.parse(json).getAsJsonObject();
        } catch (IllegalStateException e) {
            body = new JsonObject();
        }
    }

    public int statusCode() {
        return statusCode;
    }

    public void withStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> headers() {
        return headers;
    }

    public void withHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public JsonObject body() {
        return body;
    }

    public void withBody(JsonObject body) {
        this.body = body;
    }

}
