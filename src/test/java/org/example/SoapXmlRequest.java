package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class SoapXmlRequest {

    @Test
    public void validateSoapXml() throws IOException {
        File file = new File("./Folder/soap.xml");
        FileInputStream input = new FileInputStream(file);



        String requestBody = IOUtils.toString(input, "UTF-8");
        baseURI = "https://www.crcind.com/csp/samples/SOAP.Demo.CLS?WSDL=1";

        given()
                .contentType("text/xml")  // im sendding data in xml type
                .accept(ContentType.XML)  // want response in xml type
                .body(requestBody) //it telss add 10 + 10
                .when()
                .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls") // it adds 20 /create addition 20
                .then()
                .statusCode(200)

                .log()
                .all();

    }

}
