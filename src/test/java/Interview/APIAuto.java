package Interview;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class APIAuto {

    private static final String baseURI = "https://reqres.in/api";
    private long credUserID;
    private RequestSpecification commonReqSpec;
    private ThreadLocal<String> threadTOken = new ThreadLocal<>();

    @BeforeSuite
    public void setup() {
        String loginPayload = "{ \"email\": \"vivekpdsip@gmail.com\", \"password\": \"Reqres@12345\" }";

        String token = given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .log().body()
                .extract().path("token");

        Assert.assertNotNull(token,"Token is invalid");
        ThreadLocalManager.setThreadVariable(token);
    }

    @BeforeTest
    public void setupReqSpec() {
        commonReqSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .addFilter(new AuthFilter())
                .build();

    }

    @Test
    public void testAPI() {

        given()
                .spec(commonReqSpec)
                .when()
                .get(baseURI)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("name",equalTo("name"))
                .body("id",greaterThanOrEqualTo(3));

        Response re = given()
                .spec(commonReqSpec)
                .when()
                .get(baseURI)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .extract().response();

        String name = re.jsonPath().getString("name");
        List<String> id = re.jsonPath().getList("id");



    }
}
