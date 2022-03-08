package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DsAlgoPortalpage;


public class DsAlgoPortalPage_steps {


	private DsAlgoPortalpage portalpg ;

	@Given("The user is on Ds Algo portal link")
	public void the_user_is_on_ds_algo_portal_link() {
		portalpg = new DsAlgoPortalpage(DriverFactory.getDriver());
	}

	@When("The user hits the URL {string}")
	public void the_user_hits_the_url(String URL) {
		DriverFactory.getDriver().get(URL);
	}

	@Then("User lands ds algo portal page seeing banner {string}")
	public void user_lands_ds_algo_portal_page_seeing_banner(String expContent) {
		
		String actualBanner = portalpg.bannerContent();
		System.out.println("The banner content in the portal page is : "+actualBanner);
		Assert.assertTrue(actualBanner.contains(expContent));
	}

	@And("User clicks on Get Started button")
	public void user_clicks_on_get_started_button() {
		portalpg.clickgetstarted();
	}

	@Then("User navigated to home page")
	public void user_navigated_to_home_page() {
		
		System.out.println("Url of the current page is : " + DriverFactory.getDriver().getCurrentUrl());
		Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),"https://dsportalapp.herokuapp.com/home");

	}


}

