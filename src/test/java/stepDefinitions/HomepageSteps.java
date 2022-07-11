package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import static org.junit.Assert.*;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pageObjects.DsAlgoPortalpage;
import pageObjects.HomePage;

public class HomepageSteps {
	
	
	private DsAlgoPortalpage portalpg = new DsAlgoPortalpage(DriverFactory.getDriver());
	private HomePage hp;
	String pageTitle;
	
	
	@Given("User is in the home page")
	public void user_is_in_the_home_page() {
		DriverFactory.getDriver().get("url");
		hp = portalpg.clickgetstarted();
	}
	@Then("User sees {int} panes of different <data structures>")
	public void user_sees_panes_of_different_data_structures(Integer expDSpanesSize,DataTable expDSlist) {
	   
		Assert.assertTrue(hp.getDSPanesSize()==expDSpanesSize);
		 List<String> explist = expDSlist.asList();
		 System.out.println("Expected list of data structures :" + explist);
		
		List<String> actDSlist =  hp.getDSPanesList();
		 System.out.println("Actual list of data structures :" + actDSlist);
		Assert.assertTrue(actDSlist.containsAll(explist));
}

	@When("User clicks Get Started button below any one of the <data structures>")
	public void user_clicks_get_started_button_below_any_one_of_the_data_structures(DataTable dsgetstarted) {
	    hp.getStartedbtn_DS();
	}

	@Then("User should see the alert message {string}")
	public void user_should_see_the_alert_message(String expMessage) {
	 
		String actAlertMsg = hp.alertMessage();
		Assert.assertTrue(actAlertMsg.contains(expMessage));
		
	}

	@When("User clicks Data Structures dropdown")
	public void user_clicks_data_structures_dropdown() {
	      
	  hp.dropDown();
	}

	@And("User sees {int} different data structure entries")
	public void user_sees_different_data_structure_entries(Integer expdscount) {
	  
	   Assert.assertTrue(hp.dropDownsize()== expdscount);
	}

	@When("User selects any one of the data Structure in dropdown")
	public void user_selects_any_one_of_the_data_structure_in_dropdown() {
	    hp.Dropdown_selection();
	}

	@When("User clicks on the Sign in link")
	public void user_clicks_on_the_sign_in_link() {
	 hp.clicksignin();
	}

	@Then("User sees the title of the navigated page as {string}")
	public void user_sees_the_title_of_the_navigated_page_as(String expPageTitle) {
	  
		String pageTitle = hp.pagetitle();
		System.out.println("Page title is : " +pageTitle);
		Assert.assertTrue(pageTitle.contains(expPageTitle));
	}
	
	@When("User clicks on the Register link")
	public void user_clicks_on_the_register_link() {
	hp.register();   
	}
	


	

	

}
