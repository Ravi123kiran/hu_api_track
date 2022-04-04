import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
public class task_1 {
    /*
     * We set same baseUri and basePath for both request.
     */
    @Test
    public void Request1() {
        RequestSpecification request = RestAssured.given();
        // Setting Base URI
        request.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request.basePath("/booking");

        Response response = request.get();

        System.out.println(response.asString());
    }
}