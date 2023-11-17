package TestCases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CriarTokenParaAutenticacaoTest {

    @Test
    @DisplayName("Testes de API Rest criar token para autenticação")
    public void testDadoQueTenhoLoginESenhaQuandoLogarEntaoObtenhoTokenStatusCode200() {
        baseURI = ("https://open-souce.azurewebsites.net/");
        basePath="";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"fernanda@gmail.com\",\n" +
                        "    \"password\": \"123456\"\n" +
                        "}")
        .when()
                .post("api/auth")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Criar token para autenticação - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste criar token para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste token para autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste criar token para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste token para autenticação, Fail!");
            extent.flush();
        }
    }
}

