package uwu.adderapi;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class ControllerTests {

    @Test
    public void test() {
        given()
        .when()
            .get("http://localhost:8080/adder/current")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON);
    }

    @Test
    public void test2() {
        given().param("num", 5)
        .when()
            .post("http://localhost:8080/adder/")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body(equalTo("5"))
        ;
    }


}
