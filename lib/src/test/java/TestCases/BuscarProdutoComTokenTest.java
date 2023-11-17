package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BuscarProdutoComTokenTest {

    @Test
    @DisplayName("Buscar Produto com token")
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
                .get("api/product")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar produto com token - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar produto com token - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar produto com token, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar produto com token- Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar produto com token, Fail!");
            extent.flush();
        }
    }

}
