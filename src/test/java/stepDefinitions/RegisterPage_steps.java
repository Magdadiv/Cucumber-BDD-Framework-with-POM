package stepDefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.Registerpage;

public class RegisterPage_steps {

	Registerpage Rp = new Registerpage(DriverFactory.getDriver());
	
	@Given("User is in Register page")
	public void user_is_in_register_page() {
		DriverFactory.getDriver().get("url");
	}

	@When("User enters valid <username>,<password>,<password confirmation>")
	public void user_enters_valid_username_password_password_confirmation(DataTable login) {
		Rp.setLogin(login.row(0).get(0), login.row(1).get(0), login.row(2).get(0));
	}
	    

	@When("User clicks Register button")
	public void user_clicks_register_button() {
	   Rp.clickRegister();
	}
	@Then("User is redirected to Homepage with the messsage {string} <username>")
	public void user_is_redirected_to_homepage_with_the_messsage_username(String expMsg,DataTable username) {
	  
	   String expWelcomeMessage = expMsg.concat(username.row(0).get(0));
	   System.out.println("Concatenated message is : " +expWelcomeMessage);
	   System.out.println("Actual msg is : " + Rp.alertMessage());
	   Assert.assertEquals(Rp.alertMessage(), expWelcomeMessage);
	}

}

//@Then("User redirects to Homepage with {string} <username>")
//public void user_redirects_to_Homepage_with_username(String string, io.cucumber.datatable.DataTable dataTable) {
//
//String expectedMsg=string.concat(dataTable.row(1).get(0));
//System.out.println("Concated Expected Msg"+expectedMsg);
//Assert.assertEquals(Regpage.Alertreg.getText(),expectedMsg);
//if(Regpage.Alertreg.getText().equals(expectedMsg))
//	{
// Regpage.linkedlistGS.click();
// }
//}
