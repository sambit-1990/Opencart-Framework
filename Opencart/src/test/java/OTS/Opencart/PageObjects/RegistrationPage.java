package OTS.Opencart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountTab;
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register;
	@FindBy(name = "firstname")
	WebElement firstName;
	@FindBy(name = "lastname")
	WebElement lastName;
	@FindBy(id = "input-email")
	WebElement emailID;
	@FindBy(id = "input-telephone")
	WebElement telephone;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy(id = "input-confirm")
	WebElement confirmPassword;
	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	WebElement newsletter;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacyPolicy;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created')]")
	WebElement confirmationMessage;
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continueButton;

	public void clickMyAccount() {
		myAccountTab.click();
	}

	public void clickRegister() {
		register.click();
	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String Lastname) {
		lastName.sendKeys(Lastname);
	}

	public void enterEmailID(String email) {
		emailID.sendKeys(email);
	}

	public void enterTelephoneNumber(String number) {
		telephone.sendKeys(number);
	}

	public void enterPassword(String pswrd) {
		password.sendKeys(pswrd);
	}

	public void confirmPassword(String psswrd) {
		confirmPassword.sendKeys(psswrd);
	}

	public void newsletterSubscription() {
		newsletter.click();
	}

	public void acceptPrivacyPolicy() {
		privacyPolicy.click();
	}

	public void submitForm() {
		submit.click();
	}

	public String getConfirmationMessage() {
		String ConfirmationMessage = confirmationMessage.getText();
		return ConfirmationMessage;

	}

	public void continue_Button() {
		continueButton.click();
	}

	public void goToApplicationPage(String baseURL) {
		driver.get(baseURL);
	}

	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

}
