package allPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CartPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	CartPage cartpage;

	@FindBy(xpath = "//td[@class='cart_quantity']")
	private WebElement cartQuantity;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private void waitForElementToBeVisible(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public String verifyActualExactCartQuantityValue() {
		waitForElementToBeVisible(cartQuantity);
		return cartQuantity.getText();
	}

}
