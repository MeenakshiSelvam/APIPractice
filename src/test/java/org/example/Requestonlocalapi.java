package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Requestonlocalapi {
    @Test
    public void getMethod()
    {
        baseURI = "http://localhost:3000/";
        given()      // when or given any can be used.        // restassured can also all use gherkin keywords
                .get("http://localhost:3000/users/")
                .then()
                .statusCode(200)
                .and()
                .statusLine("HTTP/1.1 200 OK")
                .log().all();

    }
    @Test
    public void postMethod()
    {

        JSONObject obj = new JSONObject();
        obj.put("first_name","abcde");
        obj.put("last_name","xyz");
      //  obj.put("id",3);
        System.out.println(obj);
        baseURI = "http://localhost:3000/";
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .post("http://localhost:3000/users")
                .then()
                .statusCode(201)
                .log()
                .all();

    }
    @Test
    public void putMethod()
    {

        JSONObject obj = new JSONObject();
        obj.put("first_name","apple");
        obj.put("last_name","juice");
        //  obj.put("id",3);
        System.out.println(obj);
        baseURI = "http://localhost:3000";
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .put("http://localhost:3000/users/1")
                .then()
                .statusCode(200)
                .log()
                .all();

    }
    @Test
    public void patchMethod()
    {

        JSONObject obj = new JSONObject();
        obj.put("first_name","watermelon");
        obj.put("last_name","juice");
        //  obj.put("id",3);
        System.out.println(obj);
        baseURI = "http://localhost:3000";
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .patch("http://localhost:3000/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }
    @Test
    public void deleteMethod()
    {
        baseURI = "http://localhost:3000";
        when()
                .delete("/users/1")
                .then()
                .statusCode(200);
    }






    }
