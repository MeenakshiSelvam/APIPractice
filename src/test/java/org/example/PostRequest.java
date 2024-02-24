package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest {

    @Test
    public void test1() {
        // in this method, store value in json format

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","abcd");
        map.put("age",20);
        System.out.println(map);  // it prints k,v pairs but not in json format
        JSONObject obj = new JSONObject(map);  // so add dependency json, create obj, convert map into json format

        System.out.println(obj); // it prints json format
     // (or)
        System.out.println(obj.toJSONString());
        //(or)
        // we can directly create jsonobject and store values using put() as map.
        JSONObject ob = new JSONObject();
        ob.put("name","abcd");
        ob.put("age",20);
        System.out.println(ob);




    }
    @Test
    public void test2() {
        // postrequest


        JSONObject obj = new JSONObject();
        obj.put("name","abcd");
        obj.put("age",20);
        System.out.println(obj);

        baseURI = "https://reqres.in/api/";
        given()
                .header("Content-Type","application/json")  // its for- body -raw -json
                .contentType(ContentType.JSON) // its for - telling server that im creating req in json format
                .accept(ContentType.JSON)   // its for -  telling server the response should become json format
                .body(obj.toJSONString())
                .when()
                .post("https://reqres.in/api/users") // " /user " only folder path we cna give bcoz base uri we gave,
                .then().
                statusCode(201)
                .log()
                .all();



    }
    }



