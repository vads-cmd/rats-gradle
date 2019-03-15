package org.tests.rats.workers;

import com.google.gson.JsonObject;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestRequest {
    private String endpoint;
    private List<Header> headerList;
    private JsonObject body;
    private String contentType;
    private List<Cookie> cookieList;
    private Map<String, String> queryParamList;

    public RestRequest(String endpoint){
        this.endpoint = endpoint;
        headerList = new ArrayList<>();
        body = new JsonObject();
        contentType = "application/json";
        cookieList = new ArrayList<>();
        queryParamList = new HashMap<>();
    }

    public RestRequest withBody(JsonObject json){
        this.body = json;
        return this;
    }

    public RestRequest withParam(String property, String value){
        this.body.addProperty(property, value);
        return this;
    }

    public RestRequest withContent(String contentType){
        this.contentType = contentType;
        return this;
    }

    public RestRequest withHeader(String key, String value){
        Header h = new Header(key, value);
        headerList.add(h);
        return this;
    }

    public RestRequest withHeader(Header header){
        headerList.add(header);
        return this;
    }

    public RestRequest withCookie(String key, String value){
        Cookie c = new Cookie.Builder(key,value).build();
        cookieList.add(c);
        return this;
    }

    public RestRequest withCookie(Cookie cookie){
        cookieList.add(cookie);
        return this;
    }

    public RestRequest withQuery(String key, String value){
        queryParamList.put(key, value);
        return this;
    }

    public String body(){
        return this.body.toString();
    }

    public String endpoint(){
        if (queryParamList.size() != 0) {
            this.endpoint = endpoint + "?";
            for(Map.Entry<String, String> e: queryParamList.entrySet()) {
                endpoint = endpoint + e.getKey() + "=" + e.getValue() + "&";
            }
            System.out.println(endpoint);
            return this.endpoint;
        } else {
            return this.endpoint;
        }
    }

    public String contentType(){
        return this.contentType;
    }

    public Headers headers(){
        return new Headers(headerList);
    }

    public Cookies cookies(){
        return new Cookies(cookieList);
    }

}
