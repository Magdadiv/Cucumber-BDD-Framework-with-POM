package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Graph_page {

	public WebDriver driver;


	@FindBy(linkText="graph")
	WebElement graph_link;

	@FindBy(linkText="/tryEditor")
	WebElement tryEditor_btn;
	
	@FindBy(xpath="//a[@href='graph']")
	WebElement graph_getStartedbtn;
	
	@FindBy(xpath="//pre[@class=' CodeMirror-line ']")
	WebElement editor_Pythoncode;
	
	@FindBy(id="output")
	WebElement Output;
	
	@FindBy(xpath="//div[@class='CodeMirror-lines']")
	WebElement textarea_click;
	
	
	public Graph_page(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d,this);
	}
	public String pagetitle() {
		return driver.getTitle();
		}
	
	public void graphLink() {
		graph_link.click();

	}

	public void tryEditor() {
		tryEditor_btn.click();
	}	
	public void getStartedbtn_Graph() {
		graph_getStartedbtn.click();

		
	}
	public void Textarea_click() {
		textarea_click.click();
	}
	public void insert_pythonCode(String code){
		editor_Pythoncode.sendKeys(code);
		
	}
	public String output() {
		return Output.getText();
		
	}
	
}
