package org.tests.rats.workers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Methods {


    public Methods(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    public RestResponse get(RestRequest request){
        Response response = RestAssured.given()
                .contentType(request.contentType())
                .headers(request.headers())
                .cookies(request.cookies())
                .body(request.body())
                .get(request.endpoint());
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse post(RestRequest request){
        Response response = RestAssured.given()
                .contentType(request.contentType())
                .headers(request.headers())
                .cookies(request.cookies())
                .body(request.body())
                .post(request.endpoint());
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse put(RestRequest request){
        Response response = RestAssured.given()
                .contentType(request.contentType())
                .headers(request.headers())
                .cookies(request.cookies())
                .body(request.body())
                .put(request.endpoint());
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse patch(RestRequest request){
        Response response = RestAssured.given()
                .contentType(request.contentType())
                .headers(request.headers())
                .cookies(request.cookies())
                .body(request.body())
                .patch(request.endpoint());
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

    public RestResponse delete(RestRequest request){
        Response response = RestAssured.given()
                .contentType(request.contentType())
                .headers(request.headers())
                .cookies(request.cookies())
                .body(request.body())
                .delete(request.endpoint());
        RestResponse workedResponse = new RestResponse(response);
        return workedResponse;
    }

}
