package testCases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void sumitOrderTest() throws IOException {
		String prname = "ZARA COAT 3";
		 landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("ramkishan01997@gmail.com", "Ram@1997");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(prname);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay(prname);
//		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.SelectCountry();
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String confirmationMessage = confirmationPage.VerifyConfirmationMessage();

//		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(" Thankyou for the order. "));

	}
	@Test(dataProvider="login",groups= {"ddt"})
	public void sumitOrderTestDDT(String email,String pass) throws IOException {
		String prname = "ZARA COAT 3";
		 landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, pass);

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(prname);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay(prname);
//		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.SelectCountry();
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String confirmationMessage = confirmationPage.VerifyConfirmationMessage();

//		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(" Thankyou for the order. "));

	}
	
//	@Test(dependsOnMethods= {"sumitOrderTest"})
	@Test(priority=1)
	public void orderHistory() {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("ramkishan01997@gmail.com", "Ram@1997");
       OrderPage orderPage= productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplayed(productName));
       
	}
	@DataProvider(name="login")
	
	public Object[][]loginData(){
		return new Object[][] {
			{"ramkishan01997@gmail.com", "Ram@1997"},
			{"anshika@gmail.com", "Iamking@000"}
			
		};
	}
	

	
	
	/*
	  public void sumitOrderTestDDT(HashMap<string,String>input) throws IOException {
			ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("pass"));

	 @DataProvider(name="login")
	
	public Object[][]loginData(){
		HashMap<String,String>map=new HashMap<String,string>();
		map.put("email","ramk@gmail.com");
		map.put("pass","abc@123");
		map.put("prname","iphone");
		
		HashMap<String,String>map1=new HashMap<String,string>();
		map.put("email","ramkishan@gmail.com");
		map.put("pass","Ram@123");
		map.put("prname","watch");
		
		return new Object[][] {{map},{map1}};		
	}
	 
	 */

}
