package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GetPostSteps implements En {

    private static ResponseOptions<Response> response;

    public GetPostSteps() {

        //----------------------------------------------//
        //--------- GetPost.feature reference ----------//
        //----------------------------------------------//

        Given("^I perform GET operation for number \"([^\"]*)\"$", (String arg0) -> {
            BDDStyleMethod.SimpleGetPOstMethod(arg0);
        });



        Given("^I perform GET operation to check contains for number \"([^\"]*)\"$", (String arg0) -> {
            BDDStyleMethod.performContainsCollection();
        });

        Given("^I perform GET operation for post number \"([^\"]*)\"$", (String arg0) -> {
            BDDStyleMethod.performPathParameter(arg0);
        });

        Given("^I perform query parameter to GET operation for post number \"([^\"]*)\"$", (String arg0) -> {
            BDDStyleMethod.performQueryParameter(arg0);
        });

        Then("^I should see author name as \"([^\"]*)\"$", (String arg0) -> {
            //  System.out.println("Inside Then");

        });

        //Post Operation

        Given("^I perform post with body parameter for \"([^\"]*)\"$", (String arg0) -> {
            BDDStyleMethod.performPostWithBodyParameter(arg0);
        });

        Then("^I should see new post added$", () -> {
        });



        //----------------------------------------------//
        // ------- GetPost2.feature reference --------- //
        //----------------------------------------------//
        // Get Operation
        Given("^I perform GET operation for post \"([^\"]*)\"$", (String url) -> {
            response= RestAssuredExtension.GetOps(url);
        });

        Then("^I should see author name has Item \"([^\"]*)\"$", (String authorName) -> {
            assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
        });

        // Post Operation
        Given("^I perform post operation for \"([^\"]*)\"$", (String url) -> {
            response = RestAssuredExtension.PostOps(url);
        });
        Then("^I should see response has author name \"([^\"]*)\"$", (String authorName) -> {
            assertThat(response.getBody().jsonPath().get("author"), is(authorName));

        });


        Given("^I perform post operation for \"([^\"]*)\" with body$", (String url, DataTable data) -> {
            //  set body
            HashMap<String,String> body = new HashMap<>();
            body.put("name",data.cell(1,0));

            // Path Params
            HashMap<String,String> pathParams = new HashMap<>();
            pathParams.put("profileNo",data.cell(1,1));

            response =RestAssuredExtension.PostOpsWithBodyAndPathParams(url,pathParams,body);

        });
        Then("^I should see body has name as \"([^\"]*)\"$", (String name) -> {
            assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
        });


    }
}
