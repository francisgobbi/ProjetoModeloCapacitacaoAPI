package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class GetCartTest {

    @Test
    @DisplayName("Status get cart")
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
        
        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar token ok - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste Buscar token ok - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste get cart, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste Buscar token ok - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste get cart, Fail!");
            extent.flush();
        }
  

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
               
        .when()
                .get("api/cart")

        .then()
                .log().all();

        Response response1 = given().contentType("application/json").get(baseURI);
        ExtentReports extent1 = new ExtentReports();
        ExtentSparkReporter spark1 = new ExtentSparkReporter("Report/" + "Buscar get cart - Status Code " + response1.getStatusCode() + ".html");
        extent1.attachReporter(spark1);

        if (response.getStatusCode() == 200) {
            extent1.createTest("Teste get cart - Status Code " + response1.getStatusCode())
                    .log(Status.PASS, "Teste get cart, Passed!");
            extent1.flush();
        } else {
            extent1.createTest("Teste get cart - Status Code " + response1.getStatusCode())
                    .log(Status.FAIL, "Teste get cart, Fail!");
            extent1.flush();
        }
    }

}
