package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {

	
	private By type_username = By.id("id_username");
	private By type_password1 = By.id("id_password1");
	private By type_password2 = By.id("id_password2");
	private By register_btn = By.xpath("//*[@type='submit']");
	private By alertMsg = By.xpath("//div[@class='alert alert-primary']");
	
	 WebDriver driver = null;
	 
	public Registerpage(WebDriver d) {
		driver =d;
	}
	
	public void setLogin(String username,String password1,String password2) {
		driver.findElement(type_username).sendKeys(username);
		driver.findElement(type_password1).sendKeys(password1);
		driver.findElement(type_password2).sendKeys(password2);
			
	}
	public void setUsername(String username) {
		driver.findElement(type_username).sendKeys(username);
	}
	public void setPassword1(String password1) {
		driver.findElement(type_password1).sendKeys(password1);
	}
	
	public void setPassword2(String password2) {
		driver.findElement(type_password2).sendKeys(password2);
	}
	
	public void clickRegister() {
		driver.findElement(register_btn).click();
		}
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	public String alertMessage() {
		return driver.findElement(alertMsg).getText();
	}
	
	
}
