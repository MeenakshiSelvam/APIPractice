package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; //matchers should be imported then only body("",equals()) can be generated.


public class ApiTest3 {
    @Test
    public void test1() {
        //getrequest
        baseURI = "https://reqres.in/api/";
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)

               //.body("data[1].first_name", equalTo("Lindsay"));
                // we can get specific index and check is it equal or not

                // (or)

                  .body("data.first_name", hasItems("Lindsay","George"));
                // we can check given items is in total first_name collections.


    }

}
