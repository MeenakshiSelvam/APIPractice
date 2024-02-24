package org.example;

import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath; //if its static don't use jsonschemavalidator,matches(),use only matches()

public class ValidateJsonSchema {
    @Test
    public void getMethod() {
        baseURI = "https://reqres.in/api/";

        given()// restassured can also all use gherkin keywords
                .get("https://reqres.in/api/users?page=2")
                .then().assertThat().body(matchesJsonSchemaInClasspath("file.json")) // "file.json" file should be added in /target/classess/file.json
                .statusCode(200);

    }
}
