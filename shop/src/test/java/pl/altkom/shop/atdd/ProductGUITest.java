package pl.altkom.shop.atdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductGUITest {
	private ChromeDriver driver;

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils
						.copyFile(scrFile,
								new File("c:\\tmp\\" + description.getClassName() + "_" + description.getMethodName()
										+ ".png"));
			} catch (IOException e1) {
				System.out.println("Fail to take screen shot");
			}
			driver.quit();
		}

		@Override
		protected void succeeded(Description description) {
			driver.quit();
		}
	};

	@Before
	public void prepare() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/shop/");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("user");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("user");

		password.submit();
	}

	@Test
	public void shoulDeleteProduct() throws Exception {
		// given
		driver.findElement(By.linkText("Products list")).click();
		List<WebElement> rows = driver.findElements(By.cssSelector("table>tbody>tr"));
		int rowsSize = rows.size();
		WebElement findElement = rows.get(0).findElement(By.tagName("a"));

		// when
		Thread.sleep(1000);
		findElement.click();
		Thread.sleep(1000);

		// then
		rows = driver.findElements(By.cssSelector("table>tbody>tr"));
		assertThat(rows.size()).isLessThan(rowsSize);
	}
}
