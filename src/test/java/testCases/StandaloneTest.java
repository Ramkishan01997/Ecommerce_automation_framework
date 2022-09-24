package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

public class StandaloneTest extends BaseTest {

	@Test
	public void add_to_cart() throws IOException {
    	String prname="ZARA COAT 3";
		LandingPage landingPage=launchApplication();
		ProductCatalogue productCatalogue=landingPage.loginApplication("ramkishan01997@gmail.com", "Ram@1997");
	
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(prname);
		CartPage cartPage=	productCatalogue.goToCart();
        Boolean match=cartPage.verifyProductDisplay(prname);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage=cartPage.goToCheckOut();
		checkOutPage.SelectCountry();
		ConfirmationPage confirmationPage=checkOutPage.submitOrder();
		
		String confirmationMessage=confirmationPage.VerifyConfirmationMessage();
		
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(" Thankyou for the order. "));
		driver.close();
	
	}
	
	
}
