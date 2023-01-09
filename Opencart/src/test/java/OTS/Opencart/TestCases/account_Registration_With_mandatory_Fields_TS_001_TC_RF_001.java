package OTS.Opencart.TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OTS.Opencart.PageObjects.RegistrationPage;
import OTS.Opencart.Utilities.Retry;

public class account_Registration_With_mandatory_Fields_TS_001_TC_RF_001 extends BaseTests {

	
	@Test(retryAnalyzer=Retry.class)
	public void accountRegistrationWithMandatoryFields() throws InterruptedException {
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goToApplicationPage(baseURL);
		logger.info("URL opened");
		rp.clickMyAccount();
		rp.clickRegister();
		logger.info("Registration page displayed");
		rp.enterFirstName(firstname);
		logger.info("Firstname entered");
		rp.enterLastName(Lastname);
		logger.info("Lasttname entered");
		String finalemail = getString()+emaildom;
		rp.enterEmailID(finalemail);
		logger.info("email entered");
		String phoneNumber = getNumber(); 
		rp.enterTelephoneNumber(phoneNumber);
		logger.info("Number entered");
		rp.enterPassword(pswrd);
		logger.info("Password entered");
		rp.confirmPassword(psswrd);
		logger.info("Password confirmed");
		rp.newsletterSubscription();
		rp.acceptPrivacyPolicy();
		logger.info("Privacy Policy Accepted");
		rp.submitForm();
		String ConfirmationMessage = rp.getConfirmationMessage();
		Assert.assertTrue(ConfirmationMessage.contains("Your Account Has Been Created"));
		logger.info("Form Submitted");
		rp.continue_Button();
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("My Account"));

	}
	
	public String getString()
	{
		String emailName = RandomStringUtils.randomAlphabetic(5);
		return emailName;
	}
	public String getNumber()
	{
		String num = RandomStringUtils.randomNumeric(10);
		return num;
	}
	
	
}
