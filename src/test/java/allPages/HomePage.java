package allPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//h2[normalize-space()='Features Items']")
	private WebElement FeaturesItemsTitleInHomePage;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement ProductsButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private void waitForElementToBeVisible(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public String VerifyNavigateToHomePageSuccessfully() {
		waitForElementToBeVisible(FeaturesItemsTitleInHomePage);
		return FeaturesItemsTitleInHomePage.getText();
	}

	public void clickProductsButton() {
		waitForElementToBeVisible(ProductsButton);
		ProductsButton.click();
	}
}
