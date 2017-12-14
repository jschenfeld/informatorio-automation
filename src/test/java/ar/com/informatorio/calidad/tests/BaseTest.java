package ar.com.informatorio.calidad.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}
}
