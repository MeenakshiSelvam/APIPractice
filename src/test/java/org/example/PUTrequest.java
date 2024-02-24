package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PUTrequest {
    @Test
    public void test1() {
        // putrequest


        JSONObject obj = new JSONObject();
        obj.put("name","xyz");
        obj.put("age",20);
        System.out.println(obj);

        baseURI = "https://reqres.in/api/";
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then().
                statusCode(200)
                .log()
                .all();



    }
}

