package ar.com.informatorio.calidad.test;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

public abstract class BaseTest {

	protected WebDriver driver;

	@BeforeSuite
	public void getDriver() {
		System.out.println("Gettting browser driver.");
		OperaDriverManager.getInstance().setup();
		ChromeDriverManager.getInstance().forceCache().setup();
		FirefoxDriverManager.getInstance().setup();
	}

	@BeforeMethod
	@Parameters("browser")
	public void abrirNavegador(@Optional String navegador) {
		if (StringUtils.isBlank(navegador)) {
			navegador = "chrome";
		}
		System.out.println("Opening browser.");

		switch (navegador) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			option.setHeadless(true);
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "opera":
			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("El navegador " + navegador + " no esta soportado");
		}
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void cerrarNavegador() {
		System.out.println("Closing browser.");
		if (null != driver) {
			driver.quit();
		}
	}
}