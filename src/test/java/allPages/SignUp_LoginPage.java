package allPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp_LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	//New User Sign Up Locators
	@FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
	private WebElement NewUserSignUpHeaderTextValue;
	
	@FindBy(name = "name")
	private WebElement NameInputFieldForSignUp;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement EmailAddressInputFieldForSignUp;
	
	@FindBy(xpath = "(//button[normalize-space()='Signup'])[1]")
	private WebElement SignUpButton;
	
	@FindBy(xpath = "(//b[normalize-space()='Enter Account Information'])[1]")
	private WebElement HeadingOfSignUpPage; 
	
	public SignUp_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private void waitForElementToBeVisible(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public String VerifyNewUserSignUpIsVisible() {
		waitForElementToBeVisible(NewUserSignUpHeaderTextValue);
		return NewUserSignUpHeaderTextValue.getText();
	}
	
	public void functionalityOfFillUpNameFieldAndEmptyEmailField(String name) {
		waitForElementToBeVisible(NameInputFieldForSignUp);
		NameInputFieldForSignUp.sendKeys(name);
		SignUpButton.click();
	}
	
	public void functionalityOfFillUpEmailFieldAndEmptyNameField(String email) {
		waitForElementToBeVisible(EmailAddressInputFieldForSignUp);
		EmailAddressInputFieldForSignUp.sendKeys(email);
		SignUpButton.click();
	}
	
	public void functionalityOfEmptyEmailFieldAndEmptyNameField() {
		SignUpButton.click();
	}
	
	public void functionalityOfFillupNameAndEmailField(String name, String email) {
		waitForElementToBeVisible(NameInputFieldForSignUp);
		NameInputFieldForSignUp.sendKeys(name);
		waitForElementToBeVisible(EmailAddressInputFieldForSignUp);
		EmailAddressInputFieldForSignUp.sendKeys(email);
		waitForElementToBeVisible(SignUpButton);
		SignUpButton.click();
	}
	
	public String ActualHeadingOfSignUpPage() {
		waitForElementToBeVisible(HeadingOfSignUpPage);
		return HeadingOfSignUpPage.getText();
	}
	
	
	
}
