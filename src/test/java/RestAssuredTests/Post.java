package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Post {

    @Test
    public void PutRequest1(){
        JSONObject request = new JSONObject();
       // request.put("userId","1");
        request.put("id","1");
        request.put("title","Tester");
        request.put("body","liberty");

        System.out.println(request.toJSONString());
        baseURI = "https://jsonplaceholder.typicode.com/";
        given()
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/posts")
                .then().statusCode(201).log().all();

    }
    }


