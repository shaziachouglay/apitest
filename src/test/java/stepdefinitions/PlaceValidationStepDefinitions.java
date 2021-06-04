package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testresources.TestDataBuild;
import testresources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class PlaceValidationStepDefinitions extends Utils {
    RequestSpecification req;
    ResponseSpecification responseSpecification;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @When("user calls {string} with post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
         response =  req.when().post("/maps/api/place/add/json")
                .then().spec(responseSpecification).extract().response();
    }

    @Then("the Api call is success with status code {int}")
    public void theApiCallIsSuccessWithStatusCode(int arg0) {
        assertThat(response.getStatusCode()).isEqualTo(arg0);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String keyValue, String value) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        System.out.println(js.toString());
        //assertThat(js.get(keyValue)).isEqualTo(value);
    }

    @Given("Add Place payload with {string},{string} and {string}")
    public void addPlacePayloadWithAnd(String arg0, String arg1, String arg2) throws IOException {
        req = given().spec(requestSpecification()).body(data.addPlacePayload(arg0,arg1,arg2));
    }
}
