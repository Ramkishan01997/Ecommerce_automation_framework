package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"errorHandling"})
	public void submitOrderErrorMsg() throws IOException {
		String prname = "";
		 landingPage =launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("ramkisha1997@gmail.com", "Ram@1997");
		String errmsg=landingPage.getErrorMessage();
	System.out.println(errmsg);
	
	}

}
