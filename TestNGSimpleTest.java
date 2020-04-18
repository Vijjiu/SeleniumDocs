package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListenerAdapterEx.class)
public class TestNGSimpleTest {

	//public static WebDriver driver = new FirefoxDriver();

	@BeforeSuite
	public void beforesuite() {
		System.out.println("In beforeClass Example2");
	}

	@Test
	public void testGoogleTitle() {
		Reporter.log("I am executing testGoogleTitle Method");
		//driver.get("http://www.google.com");
		Reporter.log("<tr>The Browser Opened Successfully</tr>");
		Assert.assertEquals("Googl", "Google");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("In beforeClass Example2");
	}

	// @Test
	// public void testHexBytesTitle() {
	//
	// driver.get("http://www.hexbytes.com");
	// Assert.assertEquals("Google",driver.getTitle());
	// }
}
