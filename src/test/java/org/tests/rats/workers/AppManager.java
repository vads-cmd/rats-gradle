package org.tests.rats.workers;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppManager {
    private String baseUrl = "https://reqres.in";
    RequestSpecification httpRequest;

    private void connect() {
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();
    }

    public RestResponse get(String endpoint, JsonObject params){
        connect();
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .body(params)
                .get(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse get(String endpoint){
        connect();
        Response response = httpRequest.get(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse post(String endpoint, JsonObject params){
        connect();
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .body(params.toString())
                .post(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse post(String endpoint){
        connect();
        Response response = httpRequest.post(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse put(String endpoint, JsonObject params){
        connect();
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .body(params.toString())
                .put(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse put(String endpoint){
        connect();
        Response response = httpRequest.put(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse patch(String endpoint, JsonObject params){
        connect();
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .body(params.toString())
                .patch(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse patch(String endpoint){
        connect();
        Response response = httpRequest.patch(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse delete(String endpoint, JsonObject params){
        connect();
        Response response = httpRequest
                .header("Content-Type", "application/json")
                .body(params.toString())
                .delete(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse delete(String endpoint){
        connect();
        Response response = httpRequest.delete(endpoint);
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }
}
