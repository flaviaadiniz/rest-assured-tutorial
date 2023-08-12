package definitions;

import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class API_GETDefinitions {


    private ValidatableResponse validatableResponse;

    private String endpoint = "http://dummy.restapiexample.com/api/v1/employee/1";

    @Given("I send a request to the URL to get user details")
    public void sendRequest(){
        validatableResponse = given().contentType(ContentType.JSON)
                .when().get(endpoint).then();

        System.out.println("Response :"+validatableResponse.extract().asPrettyString());
    }

    @Then("the response will return status {int} and id {int} and salary {int} and name {string} and age {int} and message {string}")
    public void verifyStatus(int statusCode, int id, int emp_Salary, String emp_name, int emp_age, String message ){

        validatableResponse.assertThat().statusCode(statusCode).body("data.id",equalTo(id)).and()
                .body("data.employee_salary",equalTo(emp_Salary)).body("data.employee_name",equalTo(emp_name))
                .body("data.employee_age",equalTo(emp_age)).body("message",equalTo(message));
    }
}