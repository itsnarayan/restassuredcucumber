package steps;

import io.restassured.http.ContentType;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDDStyleMethod {
    static String baseUri = "http://localhost:3000";

    public static void SimpleGetPOstMethod(String postNumber){
        given().contentType(ContentType.JSON).accept(ContentType.JSON);
        when().get(String.format(baseUri+"/posts/%s",postNumber)).
                        then().body("author",is("Narayan"));
    }


    public static void performContainsCollection( ){
        given().contentType(ContentType.JSON).accept(ContentType.JSON);
        when().get(String.format(baseUri+"/posts")).
                then().body("author", hasItems("Narayan","Thomas"));
    }

    public static void performPathParameter(String postnum){
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON);
        with()
                .pathParam("postNumber",postnum).
        when()
                .get(baseUri+"/{postNumber}").
        then().
            body("author",containsString("Narayan"));
    }

    public static void performQueryParameter(String postnum){
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .queryParam("id",postnum).
        when()
                .get(baseUri+ "/posts/").
        then().
                body("author",hasItems("Narayan"));
    }

    public static void performPostWithBodyParameter(String url){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("id","4");
        postContent.put("author","Peter");
        postContent.put("title","RestAssured");

        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON).
        with().
                body(postContent).
        when()
                .post(baseUri+ url +"/").
        then().
                body("author",is("Peter"));
    }
}
