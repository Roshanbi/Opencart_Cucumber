package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class RegistrationSteps {
	WebDriver driver;
	HomePage hp;
	AccountRegistrationPage regPage;


	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() {
		
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();

	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		regPage = new AccountRegistrationPage(BaseClass.getDriver());
		regPage.setFirstName(dataMap.get("firstName"));
		regPage.setLastName(dataMap.get("lastName"));
		regPage.setEmail(BaseClass.randomString()+"@gamil.com");
		regPage.setTelephone(dataMap.get("telephone"));
		regPage.setPassword(dataMap.get("password"));
		regPage.setConfirmPassword(dataMap.get("password"));
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
		
		regPage.setPrivacyPolicy();

	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
      
		regPage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {

	String confmsg = regPage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
}
