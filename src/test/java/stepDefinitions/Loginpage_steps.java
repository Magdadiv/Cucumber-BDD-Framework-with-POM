package stepDefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogIn_Page;



public class Loginpage_steps {

	//private LogIn_Page LP = new LogIn_Page(DriverFactory.getDriver());
	private LogIn_Page LP = new LogIn_Page(DriverFactory.getDriver());
	

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/login");
	}
	@When("User enters  valid <username> ,<password>")
	public void user_enters_valid_username_password(DataTable login) {
	      
		LP.setlogin(login.row(1).get(0), login.row(1).get(1));
	}

	@And("Clicks login button")
	public void clicks_login_button() {
		LP.ClickLogin();    
		
	}
	@Then("User sees the message {string} with <username> on the top in the Home page.")
	public void user_sees_the_message_with_on_the_top_in_the_home_page(String expMsg, DataTable username) {
	
		System.out.println("actual alert message :" + LP.alertMessage());
	Assert.assertEquals(LP.alertMessage(), expMsg);
	Assert.assertEquals(LP.usernameDisplay(),username.row(1).get(0));
	}
	
	@When("User enters  invalid <username>,<password>")
	public void user_enters_invalid_username_password(DataTable invalidLogin) {
		LP.setlogin(invalidLogin.row(1).get(0), invalidLogin.row(1).get(1));
	}
	@Then("User sees the message {string}")
	public void user_sees_the_message(String expMsg) {

		Assert.assertEquals(LP.invalidloginAlertMsg(),expMsg);
	}

	
}