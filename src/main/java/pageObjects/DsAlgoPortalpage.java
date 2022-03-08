package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DsAlgoPortalpage {

	public WebDriver driver;


	@FindBy(xpath="//*[@class='btn']")
	WebElement getstarted_button;

	@FindBy(xpath="/html/body/div[1]/div/div/h1")
	WebElement banner;

	public DsAlgoPortalpage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d,this);
	}
	public String bannerContent() {
		return banner.getText();

	}

	public HomePage clickgetstarted() {
		 getstarted_button.click();
		 return new HomePage(driver);
	}
	
	
	

}
