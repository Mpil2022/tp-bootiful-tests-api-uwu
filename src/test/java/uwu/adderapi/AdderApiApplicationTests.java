package uwu.adderapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uwu.adderapi.addition.AdderService;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootTest
class AdderApiApplicationTests {

    @Test
    void test() {
        given()
        .when()
            .get("http://localhost:8080/adder/current")
        .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON);
    }

}
