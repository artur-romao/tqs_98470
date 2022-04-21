package com.lab7;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.beans.Transient;


class AppTest {

	@Test
	void availableEndpoint() {
		get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200);
	}

    @Test
    void queryTodo4() {
        get("https://jsonplaceholder.typicode.com/todos/4").then().body("title", equalTo("et porro tempora"));
    }

    @Test
    void listAllTodosGet198And199() {
        get("https://jsonplaceholder.typicode.com/todos").then().body("id", hasItems(198, 199));
    }
}
