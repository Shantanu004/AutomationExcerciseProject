package testCasesofPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allPages.CartPage;
import allPages.HomePage;
import allPages.ProductsPage;
import base.BaseClass;

public class TestCaseOfCartPage extends BaseClass {

	HomePage homepage;
	ProductsPage productpage;
	CartPage cartpage;

	@BeforeMethod
	public void SetUp() {
		EdgeBrowserSetUp(); // Multiple Browser Setup to Parallel Test Case Execution in different browser
		homepage = new HomePage(driver);
		productpage = new ProductsPage(driver);
		cartpage = new CartPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		quitBrowser();
	}

	@Test(priority = 1)
	public void verifyExactProductCartQuantityDisplayedInCartPage() {
		Assert.assertEquals(homepage.VerifyNavigateToHomePageSuccessfully(),
				PropForDataInfo.getProperty("ExpectedTitleOfHomePage"), "Home Page is not visible.");
		productpage.clickOnViewProductButton();
		Assert.assertEquals(productpage.verifyAcutalProductDetailsIsOpened(),
				PropForDataInfo.getProperty("ExpectedProductNameTitleInProductDetails"),
				"Wrong Product details is opened");
		productpage.increaseProductQuantityUptoFour();
		productpage.clickOnAddToCartButton();
		productpage.clickOnViewCartButton();
		Assert.assertEquals(cartpage.verifyActualExactCartQuantityValue(),
				PropForDataInfo.getProperty("ExpectedCartQuantity"), "Incorrect Cart Quantity is Displayed");
	}
}
