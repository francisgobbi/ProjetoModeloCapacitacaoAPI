package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DeleteCartTest {

    @Test
    @DisplayName("Status delete cart")
    public void testDadoUsuarioQuandoObtenhoTokenEBuscoPorumProdutoEntaoObtenhoStatusCode200(){
        baseURI = ("https://open-souce.azurewebsites.net/");
        basePath = "";

        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"fernanda@gmail.com\",\n" +
                        "  \"password\": \"123456\"\n" +
                        "}")
        .when()
                .post("api/auth")

        .then()
                .log().all().toString();

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
               
        .when()
                .delete("api/cart/null")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get("https://open-souce.azurewebsites.net/api/cart/null");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar delete item por id - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 404) {
            extent.createTest("Teste delete item por id - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste delete item por id, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste delete item por id - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste delete item por id, Fail!");
            extent.flush();
        }
    }

}
