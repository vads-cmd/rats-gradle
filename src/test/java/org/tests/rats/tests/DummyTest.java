package org.tests.rats.tests;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import org.tests.rats.models.Dummy.*;
import org.tests.rats.workers.RestResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.tests.rats.workers.TestData.*;

public class DummyTest extends TestBase {


    @Test (description = "GET all users")
    public void testGetUsers() {
        RestResponse response = app.get("/api/users");

        DummyGetListUsers responseData = gson.fromJson(response.body(), DummyGetListUsers.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getTotalPages(), 4 );
        assertEquals(responseData.getData().size(), 3);
    }

    @Test (description = "GET User with ID = 2")
    public void testGetUser() {
        RestResponse response = app.get("/api/users/2");

        DummyGetUser responseData = gson.fromJson(response.body(), DummyGetUser.class);

        System.out.println(responseData);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getData().getId(), 2);
    }

    @Test (description = "GET 404 page as no user exists")
    public void testGetUserNotFound() {
        RestResponse response = app.get("/api/users/23");

        assertEquals(response.statusCode(), 404);
        assertTrue(response.body().size() == 0 );
    }

    @Test (description = "POST new user")
    public void testPostSingleUser() {
        DummyPostCreate requestData = new DummyPostCreate();
        requestData.setName(fullName());
        requestData.setJob(occupation());

        JsonObject params = new JsonObject();
        params.addProperty("name", requestData.getName());
        params.addProperty("job", requestData.getJob());

        RestResponse response = app.post("/api/users", params);
        DummyPostCreate responseData = gson.fromJson(response.body(), DummyPostCreate.class);

        assertEquals(response.statusCode(), 201);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());
    }

    @Test (description = "PUT update user DummyUserData")
    public void testPutSingleUser() {
        DummyPutUpdate requestData = new DummyPutUpdate();
        requestData.setName(fullName());
        requestData.setJob(naughtyString64());

        JsonObject params = new JsonObject();
        params.addProperty("name", requestData.getName());
        params.addProperty("job", requestData.getJob());

        RestResponse response = app.put("/api/users/770", params);
        DummyPutUpdate responseData = gson.fromJson(response.body(), DummyPutUpdate.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());
    }

    @Test (description = "PATCH update user DummyUserData")
    public void testPatchSingleUser() {
        DummyPatchUpdate requestData = new DummyPatchUpdate();
        requestData.setName(fullName());
        requestData.setJob(naughtyString());

        JsonObject params = new JsonObject();
        params.addProperty("name", requestData.getName());
        params.addProperty("job", requestData.getJob());

        RestResponse response = app.patch("/api/users/770", params);
        DummyPatchUpdate responseData = gson.fromJson(response.body(), DummyPatchUpdate.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(responseData.getName(), requestData.getName());
        assertEquals(responseData.getJob(), requestData.getJob());
    }

    @Test (description = "DELETE update user DummyUserData")
    public void testDeleteUser() {
        RestResponse response = app.delete("/api/users/770");

        assertEquals(response.statusCode(), 204);
        assertTrue(response.body().size() == 0);
    }
}
