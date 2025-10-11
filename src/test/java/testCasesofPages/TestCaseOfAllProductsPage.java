package testCasesofPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allPages.HomePage;
import allPages.ProductsPage;
import base.BaseClass;

public class TestCaseOfAllProductsPage extends BaseClass {

	HomePage homepage;
	ProductsPage productpage;

	@BeforeMethod
	public void SetUp() {
		ChromeBrowserSetUp();
		homepage = new HomePage(driver);
		productpage = new ProductsPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		quitBrowser();
	}

	@Test(priority = 1)
	public void VerifyRelatedAllSearchProductsAreVisible() {
		Assert.assertEquals(homepage.VerifyNavigateToHomePageSuccessfully(),
				PropForDataInfo.getProperty("ExpectedTitleOfHomePage"), "Home Page is not visible.");
		homepage.clickProductsButton();
		Assert.assertTrue(productpage.verifyIsAllProductsPageVisible(), "All Products page is not visible.");
		productpage.searchForProduct(PropForDataInfo.getProperty("productName"));
		Assert.assertTrue(productpage.verifyIsSearchedProductsTitleVisible(), "Searched Products title is not visible.");
		Assert.assertEquals(productpage.verifyActualSearchedFirstProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchFirstProductName"), "No searched products found.");
		Assert.assertEquals(productpage.verifyActualSearchedSecondProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchSecondProductName"), "No searched products found.");
		Assert.assertEquals(productpage.verifyActualSearchedThirdProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchThirdProductName"), "No searched products found.");
		Assert.assertEquals(productpage.verifyActualSearchedFourthProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchFourthProductName"), "No searched products found.");
		Assert.assertEquals(productpage.verifyActualSearchedFifthProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchFifthProductName"), "No searched products found.");
		Assert.assertEquals(productpage.verifyActualSearchedSixthProductsNameIsVisible(),
				PropForDataInfo.getProperty("ExpectedSearchSixthProductName"), "No searched products found.");

	}

}
