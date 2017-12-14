package ar.com.informatorio.calidad.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters(value = { "browser", "url" })
	public void setUp(@Optional String browser, @Optional String url) {
		switch (browser) {
		case "chrome":
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();	
			break;
		case "firefox":
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser " + browser + " not supported");
		}
		driver.get(url);
	}


	@AfterMethod
	public void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}
}
