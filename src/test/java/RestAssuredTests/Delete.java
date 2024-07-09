package RestAssuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class Delete {

    @Test
    public void DeleteRequest1(){
        baseURI = "https://reqres.in";
        when()

                .delete("/api/users/2")
                .then().statusCode(204).log().all();
    }
}
