package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn_Page {
	
	
	private By Username = By.name("username");
	private By Password = By.name("password");
	private By login_button = By.xpath("//*[@type='submit']");
	private By alertMsg = By.xpath("/html/body/div[2]");
	private By userNamedisplay = By.xpath("//div[2]/ul/a[2]");
	private By InvalidLoginalertMsg = By.xpath("/html/body/div[3]");
	
	
	
	WebDriver driver= null;
	
	public LogIn_Page(WebDriver d) {
		driver = d;
	}
	public void getloginPage_title() {
		driver.getTitle();
	}

	public void setUsername(String username)
	{
		driver.findElement(Username).sendKeys(username);
	}
	public void setPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	public void ClickLogin()
	{
		driver.findElement(login_button).click();
	}
	
	public void setlogin(String username,String password) {
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
	}
	public String alertMessage() {
		return driver.findElement(alertMsg).getText();
	}
	public String usernameDisplay() {
		return driver.findElement(userNamedisplay).getText();
	}
	public String invalidloginAlertMsg() {
		return driver.findElement(InvalidLoginalertMsg).getText();
	}
	public Graph_page setlogin_graphPage(String username,String password) {
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(login_button).click();
		return new Graph_page(driver);
	}
}
