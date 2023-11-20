package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ProcessUsuarioTest {

    @Test
    @DisplayName("Status process usuario")
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
                .body("{\r\n"
                		+ "  \"products\": [\r\n"
                		+ "    {\r\n"
                		+ "      \"id\": \"\",\r\n"
                		+ "      \"quantity\": -100000000\r\n"
                		+ "    }\r\n"
                		+ "  ],\r\n"
                		+ "  \"shipping\": {\r\n"
                		+ "    \"address\": \"\",\r\n"
                		+ "    \"city\": \"\",\r\n"
                		+ "    \"state\": \"\"\r\n"
                		+ "  },\r\n"
                		+ "  \"payment\": {\r\n"
                		+ "    \"method\": \"\",\r\n"
                		+ "    \"transactionId\": \"\"\r\n"
                		+ "  },\r\n"
                		+ "  \"createdAt\": \"2023-08-24T19:51:55.71Z\",\r\n"
                		+ "  \"userId\": \"\"\r\n"
                		+ "}")
        .when()
                .post("api/order/process")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar order process - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar order process - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar order process, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar order process - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar order process, Fail!");
            extent.flush();
        }
    }

}
