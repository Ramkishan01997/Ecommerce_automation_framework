package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testCases.BaseClass;

public class CheckOutPage extends BaseClass {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement countrySelect;

	@FindBy(css = ".action__submit")
	WebElement submit;
	// driver.findElement(By.cssSelector(".action__submit")).click();
	By result = By.cssSelector(".ta-results");

	public void SelectCountry() {
		Actions act = new Actions(driver);
		act.sendKeys(country, "india");
		waitForElementToAppear(result);
		countrySelect.click();

//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));

//		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

//		driver.findElement(By.cssSelector(".action__submit")).click();

	}

	public ConfirmationPage submitOrder() {
		submit.click();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
	}
}
