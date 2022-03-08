package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utilities.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader cr;
	Properties prop;

	@Before(order=0)
	public void getProperty(){
		cr=new ConfigReader();
		prop = cr.loadproperties();

	}
	@Before(order=1)
	public void launchBrowser(){
		String browserName = prop.getProperty("browser");
		df = new DriverFactory();
		driver = df.init_driver(browserName);
	}	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);	
			scenario.attach(sourcepath, "image/png", screenshotName);	
		}
	}
}
