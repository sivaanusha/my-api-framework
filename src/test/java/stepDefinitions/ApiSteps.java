package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesReaderUtil;

public class ApiSteps {

	Response res;
	RequestSpecification reqSpecification = RestAssured.given();

	@Before
	public void setUp() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		System.out.println(
				"==========================================I am Before Hook of ApiSteps=========================================");
		PropertiesReaderUtil.getInstance();
	}

	@After
	public void cleanUp() {
		System.out.println(
				"==========================================I am After Hook of ApiSteps=========================================");
	}

	@Given("I have Base URL")
	public void i_have_Base_URL() {
		System.out.println("===============================i_have_Base_URL");
		String baseURL = System.getProperty("base_url");
		reqSpecification.baseUri(baseURL);
	}

	@Given("I have Parameters")
	public void i_have_Parameters() {
		System.out.println("===============================i_have_Parameters");
		reqSpecification.param("page", "2");

	}

	@Given("I have Headers")
	public void i_have_Headers() {
		System.out.println("===============================i_have_Headers");
		reqSpecification.header("Connection", "keep-alive");

	}

	@When("I make a Get request to End point")
	public void i_make_a_Get_request_to_End_point() {
		System.out.println("===============================i_make_a_Get_request_to_End_point");
		String endPoint = System.getProperty("get_all_users_end_point");
		res = reqSpecification.when().get(endPoint);
	}

	@Then("Reponse has status code {int}")
	public void reponse_has_status_code(Integer int1) {
		System.out.println("===============================reponse_has_status_code");

		int actualResponseCode = res.getStatusCode();
		System.out.println(actualResponseCode);
		int expectedResponseCode = 200;
		Assert.assertEquals(actualResponseCode, expectedResponseCode);

	}

	@Then("Response has Valid content type header")
	public void response_has_Valid_content_type_header() {
		System.out.println("===============================response_has_Valid_content_type_header");
		System.out.println(res.getHeader("Content-Type"));
		String actualContentTypeHeader = res.getHeader("Content-Type");
		String expectedContentTypeHeader = "application/json; charset=utf-8";

		Assert.assertEquals(actualContentTypeHeader, expectedContentTypeHeader);
	}

	@Then("Response has valid body")
	public void response_has_valid_body() {
		System.out.println("===============================response_has_valid_body");
		String expectedEmail = System.getProperty("expected_user_email");
		String actualEmail = res.then().extract().path("data[1].email");

		Assert.assertEquals(actualEmail, expectedEmail);

	}
}
