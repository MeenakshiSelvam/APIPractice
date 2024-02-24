package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class DeleteRequest {
    @Test
    public void test1() {
        //deleterequest
        baseURI = "https://reqres.in/api/";
        when()
                .delete("/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();


    }
}