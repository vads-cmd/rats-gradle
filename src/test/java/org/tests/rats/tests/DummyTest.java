package org.tests.rats.tests;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import org.tests.rats.models.Dummy.*;
import org.tests.rats.workers.RestRequest;
import org.tests.rats.workers.RestResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.tests.rats.workers.TestData.*;

public class DummyTest extends TestBase {

    private String userNumber;

    @Test (description = "GET all users")
    public void testGetUsers() {

        RestRequest request = new RestRequest("/api/users");
        RestResponse response = app.get(request);

        DummyGetListUsers responseData = gson.fromJson(response.body(), DummyGetListUsers.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getTotalPages(), 4 );
        assertEquals(responseData.getData().size(), 3);
    }

    @Test (description = "GET User with ID = 2")
    public void testGetUser() {
        RestRequest request = new RestRequest("/api/users/2");
        RestResponse response = app.get(request);

        DummyGetUser responseData = gson.fromJson(response.body(), DummyGetUser.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getData().getId(), 2);
    }

    @Test (description = "GET 404 page as no user exists")
    public void testGetUserNotFound() {
        RestRequest request = new RestRequest("/api/users/23");
        RestResponse response = app.get(request);

        assertEquals(response.statusCode(), 404);
        assertTrue(response.body().size() == 0 );
    }

    @Test (description = "POST new user")
    public void testPostSingleUser() {
        DummyPostCreate requestData = new DummyPostCreate();
        requestData.setName(fullName());
        requestData.setJob(occupation());

        JsonObject body = new JsonObject();
        body.addProperty("name", requestData.getName());
        body.addProperty("job", requestData.getJob());

        RestRequest request = new RestRequest("/api/users")
                .withBody(body);

        RestResponse response = app.post(request);
        DummyPostCreate responseData = gson.fromJson(response.body(), DummyPostCreate.class);

        assertEquals(response.statusCode(), 201);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());

        userNumber = responseData.getId();
    }

    @Test (description = "PUT update user DummyUserData", dependsOnMethods = "testPostSingleUser")
    public void testPutSingleUser() {
        DummyPutUpdate requestData = new DummyPutUpdate();
        requestData.setName(fullName());
        requestData.setJob(naughtyString64());

        JsonObject body = new JsonObject();
        body.addProperty("name", requestData.getName());
        body.addProperty("job", requestData.getJob());

        RestRequest request = new RestRequest("/api/users/" + userNumber)
                .withBody(body);

        RestResponse response = app.put(request);
        DummyPutUpdate responseData = gson.fromJson(response.body(), DummyPutUpdate.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());
    }

    @Test (description = "PATCH update user DummyUserData", dependsOnMethods = "testPostSingleUser")
    public void testPatchSingleUser() {
        DummyPatchUpdate requestData = new DummyPatchUpdate();
        requestData.setName(fullName());
        requestData.setJob(naughtyString());

        JsonObject body = new JsonObject();
        body.addProperty("name", requestData.getName());
        body.addProperty("job", requestData.getJob());

        RestRequest request = new RestRequest("/api/users/" + userNumber)
                .withBody(body);

        RestResponse response = app.patch(request);
        DummyPatchUpdate responseData = gson.fromJson(response.body(), DummyPatchUpdate.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());
    }

    @Test (description = "DELETE update user DummyUserData", dependsOnMethods = "testPostSingleUser")
    public void testDeleteUser() {

        RestRequest request = new RestRequest("/api/users/" + userNumber);
        RestResponse response = app.delete(request);

        assertEquals(response.statusCode(), 204);
        assertTrue(response.body().size() == 0);
    }
}
