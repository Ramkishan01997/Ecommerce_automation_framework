package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.OrderPage;

public class BaseClass {

	public WebDriver driver;
	public LandingPage landingPage;

	public BaseClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartHeader;

	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orderHeader;

   public CartPage goToCart() {
	   cartHeader.click();
	   CartPage cartPage=new CartPage(driver);
	   return cartPage;
   }
   public OrderPage goToOrderPage() {
	   orderHeader.click();
	   OrderPage orderPage=new OrderPage(driver);
	   return orderPage;
   }

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForElementToDisappear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
		}

}
