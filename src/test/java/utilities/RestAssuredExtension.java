package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request ;

    public RestAssuredExtension(){
        // Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec =  builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void GetOpsWithPathParameter(String url, Map<String,String> pathParams)   {
        //Act
        try{
            Request.pathParams(pathParams);
            Request.get(new URI(url));
        }catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }
    }

    public static void GetOpsWithQueryParameter(String url, Map<String,String> queryParams)   {
        //Act
        try{
            Request.queryParams(queryParams);
            Request.get(new URI(url));
        }catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }
    }

    public static ResponseOptions<Response> GetOps(String url)   {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostOps(String url){
        //Act
        try {
            HashMap<String,String> postContent = new HashMap<>();
            postContent.put("id","5");
            postContent.put("author","Taylor");
            postContent.put("title","TestNG");
            return Request.body(postContent).post(new URI(url));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    return null;
    }

    public static ResponseOptions<Response>PostOpsWithBodyAndPathParams(String url,HashMap<String,String> pathParam,HashMap<String,String> body){
        //Act
        Request.pathParams(pathParam);
        Request.body(body);
        return Request.post(url);
    }
}
