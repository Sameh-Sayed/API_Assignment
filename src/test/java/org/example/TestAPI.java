package org.example;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;

public class TestAPI {
    @Test

    public void testGet(){
        baseURI = "https://reqrs.in/api";
        given().get("/user?page=2").then().statusCode(200);


    }
    public void  testPost(){
        JSONObject req= new JSONObject();
        req.put("name","sameh");
        req.put("job","tester");
        baseURI = "https://reqrs.in/api";
        given().body(req.toJSONString()).when().post("/user").then().statusCode(201);




    }
    public void testPatch(){
        JSONObject req= new JSONObject();
        req.put("name","sameh");
        req.put("job","tester");
        baseURI = "https://reqrs.in";
        given().body(req.toJSONString()).when().post("/api/user/2").then().statusCode(200);



    }
    public void testDelete(){
        baseURI = "https://reqrs.in";
        when().delete("/api/user/2").then().statusCode(204);


    }
}
