package testCasesofPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allPages.HomePage;
import allPages.SignUp_LoginPage;
import base.BaseClass;

public class TestCaseOfSignUp_LoginPage extends BaseClass {

	HomePage homepage;
	SignUp_LoginPage signupLoginpage;
	
	@BeforeMethod
	public void SetUp() {
		EdgeBrowserSetUp();
		homepage = new HomePage(driver);
		signupLoginpage = new SignUp_LoginPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		quitBrowser();
	}
	
	@Test(priority = 0)
	public void VerifySuccessfullyNavigateToSignUp_LoginPage() {
		Assert.assertEquals(homepage.VerifyNavigateToHomePageSuccessfully(),
				PropForDataInfo.getProperty("ExpectedTitleOfHomePage"), "Home Page is not visible.");
		homepage.clickSignUp_LoginButton();
		Assert.assertEquals(signupLoginpage.VerifyNewUserSignUpIsVisible(), 
				PropForDataInfo.getProperty("ExpectedTitleForSignUp"), "SignUp Title is not visible");
	}
	
	@Test(priority = 1)
	public void VerifySignUpFuncationalityWhenEmailFieldIsEmpty() {
		homepage.clickSignUp_LoginButton();
		signupLoginpage.functionalityOfFillUpNameFieldAndEmptyEmailField(PropForDataInfo.getProperty("userName"));
		Assert.assertEquals(signupLoginpage.VerifyNewUserSignUpIsVisible(), 
				PropForDataInfo.getProperty("ExpectedTitleForSignUp"), "SignUp Title is not visible");	
	}
	
	@Test(priority = 2)
	public void VerifySignUpFuncationalityWhenNameFieldIsEmpty() {
		homepage.clickSignUp_LoginButton();
		signupLoginpage.functionalityOfFillUpEmailFieldAndEmptyNameField(PropForDataInfo.getProperty("emailAddress"));
		Assert.assertEquals(signupLoginpage.VerifyNewUserSignUpIsVisible(), 
				PropForDataInfo.getProperty("ExpectedTitleForSignUp"), "SignUp Title is not visible");	
	}
	
	@Test(priority = 3)
	public void VerifySignUpFuncationalityWhenNameFieldAndEmailFieldAreEmpty() {
		homepage.clickSignUp_LoginButton();
		signupLoginpage.functionalityOfEmptyEmailFieldAndEmptyNameField();
		Assert.assertEquals(signupLoginpage.VerifyNewUserSignUpIsVisible(), 
				PropForDataInfo.getProperty("ExpectedTitleForSignUp"), "SignUp Title is not visible");	
	}
	
	@Test(priority = 4)
	public void VerifySignUpFuncationalityWhenNameFieldAndEmailFieldAreFilledUp() {
		homepage.clickSignUp_LoginButton();
		signupLoginpage.functionalityOfFillupNameAndEmailField(PropForDataInfo.getProperty("userName"),PropForDataInfo.getProperty("emailAddress"));
		Assert.assertEquals(signupLoginpage.ActualHeadingOfSignUpPage(),
				PropForDataInfo.getProperty("ExpectedHeadingForSignUpPage"),"Sign Up Page heading not visible");
	}
	
	
	
}
