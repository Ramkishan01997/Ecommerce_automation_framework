package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class CartPage extends BaseClass {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	By chkbtn=By.cssSelector(".totalRow button");
//	List<WebElement>cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
//	Boolean status=cartproducts.stream().anyMatch(cartpr->cartpr.getText().equals("ZARA COAT 3"));
	
//	public Boolean verifyProductDisplay(String productName) {
//		
//		Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
//		return match;
//	}

	public Boolean verifyProductDisplay(String prname) {
		Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(prname));
		return match;
	}
	public CheckOutPage  goToCheckOut()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		waitForElementToAppear(chkbtn);
		js.executeScript("arguments[0].click();", checkoutEle);
//		checkoutEle.click();
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
	
}
