package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.Graph_page;
import pageObjects.HomePage;
import pageObjects.LogIn_Page;
 

public class Graph_steps {
	
	private LogIn_Page lp = new LogIn_Page(DriverFactory.getDriver());
	//private HomePage hp;
	private Graph_page gp;
	WebDriver driver;
	
	
	@Given("User already logged in to the application with valid <username> , <password>")
	public void user_already_logged_in_to_the_application_with_valid(DataTable login) {
	   DriverFactory.getDriver().get("url");
	gp =	lp.setlogin_graphPage(login.row(1).get(0), login.row(1).get(1));
	
		
	}
	@Given("user is in home page")
	public void user_is_in_home_page() {
	gp.pagetitle();
	
	   
	}

	@When("The user clicks the Get Started button in the Graph Pane")
	public void the_user_clicks_the_get_started_button_in_the_graph_pane() {
		gp.getStartedbtn_Graph();
	}

	@Then("User navigated to the Graph page")
	public void user_navigated_to_the_graph_page() {
	  gp.pagetitle();
	  System.out.println("Title of the Graph page is: "+ gp.pagetitle());
	}

	@And("The user clicks {string} in the page")
	public void the_user_clicks_in_the_page(String topics) {
	    gp.graphLink();
	}

	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String topicTitle) {
	    
	    Assert.assertEquals(gp.pagetitle(), topicTitle);
	}

	@And("user clicks Try here button")
	public void user_clicks_try_here_button() {
	   gp.tryEditor();
	}

	@Then("User navigated to {string} page")
	public void user_navigated_to_page(String string) {
		   gp.Textarea_click();
	}
	@Given("User is on the Assessment page")
	public void user_is_on_the_assessment_page() {
		 
		 System.out.println("The page title is :" + gp.pagetitle());
	}

	@When("User enters Python Code <Python code> in editor")
	public void user_enters_python_code_python_code_in_editor(DataTable code) {
	    gp.insert_pythonCode(code.row(0).get(0));	}

	@Then("User sees output as {string}")
	public void user_sees_output_as(String output) {
	   
	    Assert.assertEquals(gp.output(), output);
	}

}
