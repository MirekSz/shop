package pl.altkom.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class IdeTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testIde() throws Exception {
		selenium.open("/shop/login?logout");
		selenium.type("name=username", "user");
		selenium.type("name=password", "user");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Products list");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Add new product");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=quantity", "1");
		selenium.type("id=price", "1");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=quantity", "6");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
