package stepDefinitions;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingApisteps {
	
	RequestSpecification reqSpec=RestAssured.given();
	Response res;
	
	
	
	@Given("I have a request base url")
	public void i_have_a_request_base_url() {
		reqSpec.baseUri("http://hotel-test.equalexperts.io/booking");
		
	}

	@Given("I have a request Content type header")
	public void i_have_a_request_Content_type_header() {
		reqSpec.header("Content-Type", "application/json");
	    
	}

	@Given("I have a request body")
	public void i_have_a_request_body() {
		reqSpec.body(new File("newbooking.json"));
		
	}

	@When("I make a Post  request")
	public void i_make_a_Post_request() {
		res=reqSpec.post();
		
	}

	@Then("response code is {int}")
	public void response_code_is(Integer int1) {
	System.out.println(res.statusCode());
	Assert.assertEquals(res.statusCode(), 200);
	}

	@Then("response content type is json")
	public void response_content_type_is_json() {
		System.out.println(res.getContentType());
		Assert.assertEquals(res.getContentType(), "application/json; charset=utf-8");
	}

	@Then("response body has booking id")
	public void response_body_has_booking_id() {
		System.out.println(res.body());
		int bookingId = res.then().extract().path("bookingid");
		System.out.println(bookingId);
		Assert.assertNull(bookingId);
		
	}

	@When("I make a Get  request")
	public void i_make_a_Get_request() {
		
	}

	@When("I have a end point {string}")
	public void i_have_a_end_point(String string) {
		
	}

	@Then("response body has booking details")
	public void response_body_has_booking_details() {
		
	}

	@Given("I have authorization header")
	public void i_have_authorization_header() {
	    
	}

}
