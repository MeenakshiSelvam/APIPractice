package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Patchrequest {



        @Test
        public void test1() {
            // patchrequest


            JSONObject obj = new JSONObject();
            obj.put("name","xyz");
            obj.put("age",40);
            System.out.println(obj);

            baseURI = "https://reqres.in/api/";
            given()
                    .header("Content-Type","application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(obj.toJSONString())
                    .when()
                    .patch("/users/2") // we can give only end-point
                    .then().
                    statusCode(200)
                    .log()
                    .all();



        }
    }



