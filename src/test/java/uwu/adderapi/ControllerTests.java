package uwu.adderapi;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void test() {
        given().port(port)
        .when()
            .get("/adder/current")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON);
    }

    @Test
    public void test2() {
        given().port(port).param("num", 5)
        .when()
            .post("/adder/")
        .then()
            .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body(equalTo("5"))
        ;
    }


}
