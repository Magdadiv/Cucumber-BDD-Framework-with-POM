package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private By Register = By.linkText("Register");      	//@FindBy(link_text ="Register")WebElement Register;
	private By signin_link = By.linkText("Sign in");
	private By signout_link = By.linkText("Sign out");
	private By dataStructures_dropdown = By.xpath("//*[@class='nav-link dropdown-toggle']");
	private By dropDownsize = By.xpath("//a[@class='dropdown-item']");
	private By sixPanesOfDS =By.cssSelector("div.col h5");
	private By panesNames = By.xpath("/html/body/div[2]");

	private By DSIntro_getStartedbtn = By.xpath("//a[@href='data-structures-introduction']");
	private By array_getStartedbtn = By.xpath("//a[@href='array']");
	private By linkedList_getStartedbtn = By.xpath("//a[@href='linked-list']");
	private By stack_getStartedbtn = By.xpath("//a[@href='stack']");
	private By queue_getStartedbtn = By.xpath("//a[@href='queue']");
	private By tree_getStartedbtn = By.xpath("//a[@href='tree']");
	private By graph_getStartedbtn = By.xpath("//a[@href='graph']");
	private By alertMsg = By.xpath("//div[@class='alert alert-primary']");


	WebDriver driver = null;

	public HomePage(WebDriver d) {
		driver = d;
	}

	public void register() {
		driver.findElement(Register).click();
	}
	public void clicksignin() {
		driver.findElement(signin_link).click();
		
	}

	public void clicksignout() {
		driver.findElement(signout_link).click();
	}
	public String pagetitle() {
	return driver.getTitle();
	}
	public int getDSPanesSize() {

		int count=  driver.findElements(sixPanesOfDS).size()-1;
		System.out.println("Number of the panes is : " +count) ;
		return count;
	}

	public List<String> getDSPanesList() {
		List<String> dsPaneslist = new ArrayList<>();
		List<WebElement> DSPaneslist = driver.findElements(sixPanesOfDS);
		for(WebElement e: DSPaneslist) {
			String dstext =	e.getText();
			//	System.out.println("List of DataStructures : " + dstext);
			dsPaneslist.add(dstext);

		}
		return dsPaneslist;
	}

	public void getStartedbtn_DS() {

		driver.findElement(DSIntro_getStartedbtn).click();
		driver.findElement(array_getStartedbtn).click();
		driver.findElement(linkedList_getStartedbtn).click();
		driver.findElement(stack_getStartedbtn).click();
		driver.findElement(queue_getStartedbtn).click();
		driver.findElement(tree_getStartedbtn).click();
		driver.findElement(graph_getStartedbtn).click();

	}
	public String alertMessage() {
		return driver.findElement(alertMsg).getText();
	}
	public void dropDown() {
		driver.findElement(dataStructures_dropdown).click();
	}
	public int dropDownsize() {
		int dropdowncount = driver.findElements(dropDownsize).size();
		System.out.println("count of dropdown" + dropdowncount);
		return dropdowncount;
	}
	public void Dropdown_selection() {
		List<WebElement> ddlist = driver.findElements(dropDownsize);
		for(WebElement e: ddlist) {
			e.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			break;
		}


	}


}
