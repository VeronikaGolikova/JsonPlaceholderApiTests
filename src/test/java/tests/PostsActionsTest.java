package tests;

import model.PostsReguestModel;
import model.PostsResponseModel;
import model.PutReguestModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.GeneralSpec.loggingResponseSpec;
import static specs.GeneralSpec.requestSpec;
import static specs.GeneralSpec.responseSpec200OkWithLogging;

public class PostsActionsTest extends TestBase{

    String titleTextUser1 = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    String bodyTextUser1 = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";
    String newTitle = "Рецепт маффинов";
    String newBody = "Любимый рецепт, рекомендую. Перейдите по ссылке http://somelink.com";

    @Test
    void getPostInformation() {
        PostsResponseModel response = step("Make request", ()->
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/posts/1")
                        .then()
                        .spec(responseSpec200OkWithLogging)
                        .body(matchesJsonSchemaInClasspath("schemas/postSchema.json"))
                        .extract().as(PostsResponseModel.class));

        step("Check response", ()->
                assertAll ("Проверка полей пользователя в ответе",
                           () -> assertEquals(1, response.getUserId()),
                           () -> assertEquals(1, response.getId()),
                           () -> assertEquals(titleTextUser1, response.getTitle()),
                           () -> assertEquals(bodyTextUser1, response.getBody())
                )
        );
    }

    @Test
    void createNewPost() {
        PostsReguestModel requestBody = new PostsReguestModel();
        requestBody.setTitle(newTitle);
        requestBody.setBody(newBody);
        requestBody.setUserId(1);
        PostsResponseModel response = step("Make request", ()->
                given()
                        .spec(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("/posts")
                        .then()
                        .spec(loggingResponseSpec)
                        .statusCode(201)
                        .body(matchesJsonSchemaInClasspath("schemas/postSchema.json"))
                        .extract().as(PostsResponseModel.class));

        step("Check response", ()->
                assertAll ("Проверка полей пользователя в ответе",
                           () -> assertEquals(101, response.getId()),
                           () -> assertEquals(1, response.getUserId()),
                           () -> assertEquals(newTitle, response.getTitle()),
                           () -> assertEquals(newBody, response.getBody())
                )
        );
    }

    @Test
    void updatePost() {
        PutReguestModel requestBody = new PutReguestModel();
        requestBody.setTitle(newTitle);
        requestBody.setBody(newBody);
        requestBody.setUserId(1);
        requestBody.setId(1);
        int id = requestBody.getId();
        PostsResponseModel response = step("Make request", ()->
                given()
                        .spec(requestSpec)
                        .when()
                        .body(requestBody)
                        .put("/posts/" + id)
                        .then()
                        .spec(responseSpec200OkWithLogging)
                        .body(matchesJsonSchemaInClasspath("schemas/postSchema.json"))
                        .extract().as(PostsResponseModel.class));

        step("Check response", ()->
                assertAll ("Проверка полей пользователя в ответе",
                           () -> assertEquals(1, response.getId()),
                           () -> assertEquals(1, response.getUserId()),
                           () -> assertEquals(newTitle, response.getTitle()),
                           () -> assertEquals(newBody, response.getBody())
                )
        );
    }

    @Test
    void patchResource() {
        PutReguestModel requestBody = new PutReguestModel();
        requestBody.setTitle(newTitle);
        requestBody.setBody(newBody);
        requestBody.setId(1);
        requestBody.setUserId(1);
        PostsResponseModel response = step("Make request", ()->
                given()
                        .spec(requestSpec)
                        .when()
                        .body(requestBody)
                        .put("/posts/1")
                        .then()
                        .spec(responseSpec200OkWithLogging)
                        .body(matchesJsonSchemaInClasspath("schemas/postSchema.json"))
                        .extract().as(PostsResponseModel.class));

        step("Check response", ()->
                assertAll ("Проверка полей пользователя в ответе",
                           () -> assertEquals(1, response.getId()),
                           () -> assertEquals(1, response.getUserId()),
                           () -> assertEquals(newTitle, response.getTitle()),
                           () -> assertEquals(newBody, response.getBody())
                )
        );
    }

    @Test
    void deleteResource() {
        step("Make request", ()->
                given()
                        .spec(requestSpec)
                        .when()
                        .delete("/posts/1")
                        .then()
                        .spec(responseSpec200OkWithLogging)
                        .extract().response());
    }
}
