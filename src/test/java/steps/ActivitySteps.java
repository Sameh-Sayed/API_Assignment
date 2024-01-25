package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ActivitySteps {

    private RequestSpecification request;
    private Response response;

    @Given("the Bored API is accessible")
    public void theBoredAPIIsAccessible() {
        RestAssured.baseURI = "https://www.boredapi.com";
        request = RestAssured.given();
    }

    @When("I request an activity from the API")
    public void iRequestAnActivityFromTheAPI() {
        response = request.get("/api/activity");
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should have the correct schema")
    public void theResponseShouldHaveTheCorrectSchema() {
        ResponseBody body = response.body();
        String bodyObject = body.asString();

        Assert.assertEquals(bodyObject.contains("activity"),true,"Teach your dog a new trick");
    }


}

