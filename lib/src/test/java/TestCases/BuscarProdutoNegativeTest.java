package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BuscarProdutoNegativeTest {
    @Test
    @DisplayName("Buscar Apenas Um Produto - Negative")
    public void testDadoUsuarioQuandoTenhoCadastradoUmProdutoEBuscoPorUmIdEntaoObtenhoStatusCode404(){
        baseURI = ("https://open-souce.azurewebsites.net/");
        basePath = "";
        
        
        String  token = given()
        	.contentType(ContentType.JSON)
        	.body("{\n" +
                "    \"email\": \"fernanda@gmail.com\",\n" +
                "    \"password\": \"123456\"\n" +
                "}")
        .when()
        	.post("api/auth")

        .then()
        	.log().all().toString();

        given()
                .contentType(ContentType.JSON)
                .header("authentication",token)
       .when()
                .post("api/product")

       .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar  produto negativo - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste Buscar apenas um produto  negativo - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar apenas produto negativo, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar apenas produto negativo - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar produto  negativo, Fail!");
            extent.flush();
        }
    }
}
