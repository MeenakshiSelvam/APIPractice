package org.example;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;  //get()
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;  //body(,)

import static io.restassured.RestAssured.given;

public class ApiTest2 {

    @Test
    public void test2()
    {
//Run a Get Req



        Response response = get("https://reqres.in/api/users?page=2"); //in order to use the get method directly we have to import all statically.


        System.out.println("Status Code:  " + response.getStatusCode());
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Response Body :" + response.getBody().asString());
        System.out.println("Status Line :" + response.getStatusLine());  // status message
        System.out.println("Response Body :" + response.getHeader("Content-Type"));
        Assert.assertEquals(response.getStatusCode(),200,"assertion - error");

    }
    @Test
    public void test3()
    {
        baseURI = "https://reqres.in/api/";
        given()
                .get("https://reqres.in/api/users/")
                .then()
                .statusCode(200)
//                .body("data.id",equalTo(2)); // if getting only one id, we can use "data.id"
                .body("data[1].id",equalTo(2)).log().all();
        // if getting many id,then use "data.id[index]." [json-path]-we can also use json path finder by giving response.
//getbody() -- get and displays repsonse
// body().log().all()--- get and displays response with all information.



    }
}
