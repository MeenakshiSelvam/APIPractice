package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void test1()
    {
//Run a Get Req



        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code:  " + response.getStatusCode());
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Response Body :" + response.getBody().asString());
        System.out.println("Status Line :" + response.getStatusLine());  // status message
        System.out.println("Response Body :" + response.getHeader("Content-Type"));
        Assert.assertEquals(response.getStatusCode(),200,"assertion - error");

    }
}
