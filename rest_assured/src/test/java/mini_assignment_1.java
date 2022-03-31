import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class mini_assignment_1
{
    @Test
    public void test_get_call()
    {
        Response response=given().
                header("content-type","application/json").

                when().
                get("https://jsonplaceholder.typicode.com/posts").

                then().
                statusCode(200).extract().response();
        assertThat(response.path("[39].userId"), is(equalTo(4)));
        JSONArray arr = new JSONArray(response.asString());
        int Auto= 1;
        for(int i=0;i<arr.length();i++){

            Object obj = arr.getJSONObject(i).get("title");
            if( !(obj instanceof String) ) {
                Auto = 0;
                break;
            }
        }
        assertThat(Auto,is(equalTo(1)));

    }
    @Test

    public void test_put_call(){

        File jasonData = new File("src//test//res//Data.json");
        given().body(jasonData).
                when().
                put("https://reqres.in/api/users").
                then().
                statusCode(200).
                contentType("application/json");
    }
}
