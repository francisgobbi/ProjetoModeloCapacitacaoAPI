package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CriarProdutoTest {
    @Test
    @DisplayName("Buscar criar produto")
    public void testDadoUsuarioQuandoTenhoCadastradoProdutoEntaoObtenhoStatusCode200(){
        baseURI = ("https://open-souce.azurewebsites.net/");
        basePath = "";
        
        
        String token = given()
        	.contentType(ContentType.JSON)
        	.body("{\n" +
                "    \"email\": \"fernanda@gmail.com\",\n" +
                "    \"password\": \"123456\"\n" +
                "}")
        .when()
        	.post("api/auth")

        .then()
        	.log().all().toString();
        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Criar token - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste criar token - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste criar token, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste criar token - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste criar token, Fail!");
            extent.flush();
        }
    
        	

        given()
                .contentType(ContentType.JSON)
                .header("authentication",token)
                .body("{\r\n"
                		+ "  \"sku\": \"sku2\",\r\n"
                		+ "  \"title\": \"title2\",\r\n"
                		+ "  \"description\": \"description2\",\r\n"
                		+ "  \"price\": 5,\r\n"
                		+ "  \"quantity\": 10\r\n"
                		+ "}")
                
       .when()
                .post("api/product")

       .then()
                .log().all();

        Response response1 = given().contentType("application/json").get(baseURI);
        ExtentReports extent1 = new ExtentReports();
        ExtentSparkReporter spark1 = new ExtentSparkReporter("Report/" + "Criar produto - Status Code " + response1.getStatusCode() + ".html");
        extent1.attachReporter(spark1);

        if (response1.getStatusCode() == 200) {
            extent1.createTest("Teste criar produto - Status Code " + response1.getStatusCode())
                    .log(Status.PASS, "Teste criar produto, Passed!");
            extent1.flush();
        } else {
            extent1.createTest("Teste criar produto - Status Code " + response1.getStatusCode())
                    .log(Status.FAIL, "Teste criar produto, Fail!");
            extent1.flush();
        }
    }
}
