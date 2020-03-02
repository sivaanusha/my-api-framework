package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@Given("i am on login page")
	public void i_am_on_login_page() {
		System.out.println("====================================== Opening login page");
	}

	@When("I enter {string} in uname field")
	public void i_enter_in_uname_field(String unameStr) {
		System.out.println("======================================entering username :" + unameStr);
		
	}

	@When("I enter {string} in password field")
	public void i_enter_in_password_field(String pwdStr) {
		System.out.println("====================================== entering password :" + pwdStr);
		//passwordFieldEle.sendKeys(pwdStr)
	}

	@When("i click login button")
	public void i_click_login_button() {
		System.out.println("====================================== clicnked login button");
	}

	@Then("login status should be {string}")
	public void login_status_should_be(String loginStatusStr) {
		System.out.println("====================================== Login status is :" + loginStatusStr);
	}

}
