package misc;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ForPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Started");
		
		
		// Make a REST GET request and capture response in res object
		Response res = RestAssured.given().baseUri("https://reqres.in").param("page", "2").when().get("/api/users");

		System.out.println("===============Response Status Code===============");

		int actualResponseCode = res.getStatusCode();
		System.out.println(actualResponseCode);
		int expectedResponseCode = 200;
		Assert.assertEquals(actualResponseCode, expectedResponseCode);

		System.out.println("===============Response Status Line===============");

		 System.out.println(res.getStatusLine());

		System.out.println("===============Response Headers===============");
		// System.out.println(res.getHeaders());
		String actualContentTypeHeader = res.getHeader("Content-Type");
		String expectedContentTypeHeader = "application/json; charset=utf-8";

		Assert.assertEquals(actualContentTypeHeader, expectedContentTypeHeader);

		System.out.println("===============Response Body===============");

		// System.out.println(res.asString());
		String expectedEmail = "sadlindsay.ferguson@reqres.in";
		String actualEmail = res.then().extract().path("data[1].email");

		Assert.assertEquals(actualEmail, expectedEmail);

		System.out.println("Ended");

	}

}
