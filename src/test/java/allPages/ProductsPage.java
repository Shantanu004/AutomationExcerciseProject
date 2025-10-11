package allPages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
    //Locators of Test Case 1
	@FindBy(xpath = "//h2[normalize-space()='All Products']")
	private WebElement allProductsTitle;

	@FindBy(id = "search_product")
	private WebElement searchProductInputField;

	@FindBy(id = "submit_search")
	private WebElement searchButton;

	@FindBy(xpath = "//h2[normalize-space()='Searched Products']")
	private WebElement searchedProductsTitle;

	@FindBy(xpath = "(//div[@class='product-overlay'])[1]")
	private WebElement searchedFirstProductHoverArea;

	@FindBy(xpath = "(//div[@class='product-overlay'])[2]")
	private WebElement searchedSecondProductHoverArea;

	@FindBy(xpath = "(//div[@class='product-overlay'])[3]")
	private WebElement searchedThirdProductHoverArea;

	@FindBy(xpath = "(//div[@class='product-overlay'])[4]")
	private WebElement searchedFourthProductHoverArea;

	@FindBy(xpath = "(//div[@class='product-overlay'])[5]")
	private WebElement searchedFifthProductHoverArea;

	@FindBy(xpath = "(//div[@class='product-overlay'])[6]")
	private WebElement searchedSixthProductHoverArea;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Men Tshirt')]")
	private WebElement searchedProductMenTshirtTitleName;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Pure Cotton V-Neck T-Shirt')]")
	private WebElement searchedProductPureCottonVNeckTShirtTitleName;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Green Side Placket Detail T-Shirt')]")
	private WebElement searchedProductGreenSidePlacketDetailTShirtTitleName;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Premium Polo T-Shirts')]")
	private WebElement searchedProductPremiumPoloTShirtsTitleName;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Pure Cotton Neon Green Tshirt')]")
	private WebElement searchedProductPureCottonNeonGreenTshirtTitleName;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'GRAPHIC DESIGN MEN T SHIRT - BLUE')]")
	private WebElement searchedProductGraphicDesignMenTShirtBlueTitleName;
	
	
	// Locators For Test Case 2
	@FindBy(xpath = "(//a[contains(text(),'View Product')])[2]")
	private WebElement viewProductButton;

	@FindBy(xpath = "(//h2[normalize-space()='Men Tshirt'])[1]")
	private WebElement productNameTitleInProductDetails;
	
	@FindBy(id = "quantity")
	private WebElement productquantityField;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	private WebElement viewCartButton;
	
	
	
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
	}

	private void waitForElementToBeVisible(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
    // Functions for Test Case 1
	public boolean verifyIsAllProductsPageVisible() {
		waitForElementToBeVisible(allProductsTitle);
		return allProductsTitle.isDisplayed();
	}

	public void searchForProduct(String productName) {
		waitForElementToBeVisible(searchProductInputField);
		searchProductInputField.sendKeys(productName);
		waitForElementToBeVisible(searchButton);
		searchButton.click();
	}

	public boolean verifyIsSearchedProductsTitleVisible() {
		waitForElementToBeVisible(searchedProductsTitle);
		return searchedProductsTitle.isDisplayed();
	}

	public void mouseHoverOnFirstSearchedProduct() {
		actions.moveToElement(searchedFirstProductHoverArea).perform();
	}

	public void mouseHoverOnSecondSearchedProduct() {
		actions.moveToElement(searchedSecondProductHoverArea).perform();
	}

	public void mouseHoverOnThirdSearchedProduct() {
		actions.moveToElement(searchedThirdProductHoverArea).perform();
	}

	public void mouseHoverOnFourthSearchedProduct() {
		actions.moveToElement(searchedFourthProductHoverArea).perform();
	}

	public void mouseHoverOnFifthSearchedProduct() {
		actions.moveToElement(searchedFifthProductHoverArea).perform();
	}

	public void mouseHoverOnSixthSearchedProduct() {
		actions.moveToElement(searchedSixthProductHoverArea).perform();
	}

	public String verifyActualSearchedFirstProductsNameIsVisible() {
		mouseHoverOnFirstSearchedProduct(); // hover first so the searched product title name becomes visible
		waitForElementToBeVisible(searchedProductMenTshirtTitleName);
		return searchedProductMenTshirtTitleName.getText();
	}

	public String verifyActualSearchedSecondProductsNameIsVisible() {
		mouseHoverOnSecondSearchedProduct();
		waitForElementToBeVisible(searchedProductPureCottonVNeckTShirtTitleName);
		return searchedProductPureCottonVNeckTShirtTitleName.getText();
	}

	public String verifyActualSearchedThirdProductsNameIsVisible() {
		mouseHoverOnThirdSearchedProduct();
		waitForElementToBeVisible(searchedProductGreenSidePlacketDetailTShirtTitleName);
		return searchedProductGreenSidePlacketDetailTShirtTitleName.getText();
	}

	public String verifyActualSearchedFourthProductsNameIsVisible() {
		mouseHoverOnFourthSearchedProduct();
		waitForElementToBeVisible(searchedProductPremiumPoloTShirtsTitleName);
		return searchedProductPremiumPoloTShirtsTitleName.getText();
	}

	public String verifyActualSearchedFifthProductsNameIsVisible() {
		mouseHoverOnFifthSearchedProduct();
		waitForElementToBeVisible(searchedProductPureCottonNeonGreenTshirtTitleName);
		return searchedProductPureCottonNeonGreenTshirtTitleName.getText();
	}

	public String verifyActualSearchedSixthProductsNameIsVisible() {
		mouseHoverOnSixthSearchedProduct();
		waitForElementToBeVisible(searchedProductGraphicDesignMenTShirtBlueTitleName);
		return searchedProductGraphicDesignMenTShirtBlueTitleName.getText();
	}
	
	//Functions for Test Case 2
	public void clickOnViewProductButton() {
		waitForElementToBeVisible(viewProductButton);
		viewProductButton.click();
	}
	
	public String verifyAcutalProductDetailsIsOpened() {
		waitForElementToBeVisible(productNameTitleInProductDetails);
		return productNameTitleInProductDetails.getText();
	}

	public void increaseProductQuantityUptoFour() {
		waitForElementToBeVisible(productquantityField);
		productquantityField.click();
		 for (int i = 0; i < 3; i++) {
		        productquantityField.sendKeys(Keys.ARROW_UP);
		    }
	}
	
	public void clickOnAddToCartButton() {
		waitForElementToBeVisible(addToCartButton);
		addToCartButton.click();
	}
	
	public void clickOnViewCartButton() {
		waitForElementToBeVisible(viewCartButton);
		viewCartButton.click();
	}
}
