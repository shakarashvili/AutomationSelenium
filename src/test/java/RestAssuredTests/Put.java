package RestAssuredTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Put {

    @Test
    public void PutRequest1(){
        JSONObject request = new JSONObject();
        request.put("name","Giorgi");
        request.put("job","Tester");
        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";
        given()
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then().statusCode(200).log().all();
    }


}
