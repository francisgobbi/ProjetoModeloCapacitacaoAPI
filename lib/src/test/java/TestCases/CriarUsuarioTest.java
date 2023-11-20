
package TestCases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CriarUsuarioTest {

    @Test
    @DisplayName("Testes criar usuario")
    public void testDadoQueTenhoLoginESenhaQuandoLogarEntaoObtenhoTokenStatusCode201() {
        baseURI = ("https://open-souce.azurewebsites.net/");
        basePath="";

        given()
                .contentType(ContentType.JSON)
                .body("{\r\n"
                		+ "  \"email\": \"fernande@gmail.com\",\r\n"
                		+ "  \"password\": \"123456\",\r\n"
                		+ "  \"firstName\": \"Feranande\",\r\n"
                		+ "  \"lastName\": \"Silva\",\r\n"
                		+ "  \"userName\": \"fernandesilva\"\r\n"
                		+ "}")
        .when()
                .post("api/user-create")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar criar usuario - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste criar usuario - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste criar usuario, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste criar usuario - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste criar usuario, Fail!");
            extent.flush();
        }
    }
}

