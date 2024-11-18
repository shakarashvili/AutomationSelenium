package RestAssuredTests;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.*;


public class Get {
    @Test
    public void PerformanceTestForGetMEthod(){

       String baseURI = "https://jsonplaceholder.typicode.com/";
       long startTimeGet = System.currentTimeMillis();
       Response getResponse = RestAssured.get(baseURI );
       long endTimeGet = System.currentTimeMillis();
        System.out.println("Get Response Time " + (endTimeGet - startTimeGet) + "ms");
        System.out.println("Get Status Code: " + getResponse.getStatusCode() );
        Response response =
                given()
                        .when()
                        .get("/posts/");
        System.out.println(response.getBody().asString());

    }

@Test
    public void testGetResquest(){

    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
 Response response =
         given()
                 .when()
                 .get("/posts/1");
    System.out.println(response.getBody().asString());

}
@Test
    public void testGEt2Request(){
    baseURI = "https://reqres.in/api";
    given()
            .get("/users?page=2")
            .then().statusCode(200)
            .body("data[2].first_name", equalTo("Tobias")). //https://jsonpathfinder.com/ am saitze shevdivart path vipovit da shevadarebt im konkretuls
            body("data.first_name", hasItems("George", "Rachel"));

}
@Test
public void testGetRequest7(){
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/6");

    given()
            .then().statusCode(200)
            .body("id",hasItems(6))
            .body("title",hasItems("dolorem eum magni eos aperiam quia"));
    System.out.println(response.getStatusCode());
    response.getBody().prettyPrint();
}
@Test
public void TestGetrequestsingle(){
  //  baseURI = "https://jsonplaceholder.typicode.com/posts/1";
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
    System.out.println(response.getStatusCode());
    response.getBody().prettyPrint();
}

@Test
public void testGet3request(){
    baseURI = "https://reqres.in";
    Response response = RestAssured.get("/api/users?page=2");
    System.out.println(response.getStatusCode());
    response.getBody().prettyPrint();

         ;}
@Test
public void TestGet4request(){
    baseURI = "https://reqres.in";
    Response response = RestAssured.get("x[1]");
    System.out.println(response.getStatusCode());
   response.getBody().prettyPrint();




}



    @Test
    public void Gettest5request(){

    Response response = RestAssured.get("https://api.restful-api.dev/objects?id=3&id=5&id=10");
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
        System.out.println(response.getTime());
        System.out.println(response.getBody());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("Content-type"));
        int statuscode = response.statusCode();
        Assert.assertEquals(statuscode,200);


    }

    @Test
    public void Getrequesttest6(){
        Response response = RestAssured.get("https://api.restful-api.dev/objects?id=3&id=5&id=10");

        given()

            .then()
            .body("id",equalTo("2"))
            .body("color",equalTo("Cloudy White"));

    }
}
