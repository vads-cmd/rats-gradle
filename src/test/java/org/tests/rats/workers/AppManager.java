package org.tests.rats.workers;

import io.restassured.RestAssured;


public class AppManager {
    private String baseUrl = "https://reqres.in";
    public int pauseTimer = 2000;
    public Methods methods = new Methods(baseUrl);


    public RestResponse get(RestRequest request) {
        return methods.get(request);
    }

    public RestResponse post(RestRequest request){
        return methods.post(request);
    }

    public RestResponse put(RestRequest request){
        return methods.put(request);
    }

    public RestResponse patch(RestRequest request){
        return methods.patch(request);
    }

    public RestResponse delete(RestRequest request){
        return methods.delete(request);
    }
}
