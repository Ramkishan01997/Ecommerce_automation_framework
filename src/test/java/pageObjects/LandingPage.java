package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class LandingPage extends BaseClass {
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("ramkishan01997@gmail.com");
//	driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys("Ram@1997");

//	driver.findElement(By.xpath("//*[@id='login']")).click();
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class='fliInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		String msg=errorMessage.getText();
		return msg;
	}
	public void goTo() {
		driver.get("https://www.rahulshettyacademy.com/client");
	}

}
