package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;

	@Before
	public void setUp() throws IOException {
		//initialize method return driver that one storing into localdriver
		driver = BaseClass.initializeBrowser();
		//getProperties return the properties that we are storing into the p
		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// this screenshot method is for cucumber junit report
		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
