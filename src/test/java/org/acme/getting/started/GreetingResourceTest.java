package org.acme.getting.started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/greeting")
                .then()
                .statusCode(200)
                .body(is("Hello Testing"));
    }

    @Test
    public void testGreetingEndpoint() {
        //String uuid = UUID.randomUUID().toString();
        String name = "sg";
        given()
                .pathParam("name", name)
                .when().get("/greeting/hello/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello " + "Singapore"));
    }

}
